// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.keyvault;

import com.azure.common.http.HttpClient;
import com.azure.common.http.HttpPipeline;
import com.azure.common.http.policy.HttpLogDetailLevel;
import com.azure.common.http.policy.HttpPipelinePolicy;
import com.azure.common.http.policy.RetryPolicy;
import com.azure.common.http.policy.UserAgentPolicy;
import com.azure.common.http.policy.HttpLoggingPolicy;
import com.azure.identity.credential.AzureCredential;
import com.azure.identity.credential.TokenCredential;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class provides a fluent builder API to help aid the configuration and instantiation of the {@link SecretAsyncClient secret async client},
 * calling {@link SecretAsyncClientBuilder#build() build} constructs an instance of the client.
 *
 * <p> The configuration options {@link String vaultEndpoint} and {@link TokenCredential credentials} are required by
 * {@link SecretAsyncClientBuilder secretAsyncClientBuilder} to build the {@link SecretAsyncClient}. For credentials, if the {@link AzureCredential#DEFAULT} key vault
 * credentials are used then ensure the environment variables AZURE_CLIENT_ID, AZURE_CLIENT_SECRET and AZURE_TENANT_ID are configured.</p>
 * <pre>
 * SecretAsyncClient.builder()
 *   .vaultEndpoint("https://myvault.vault.azure.net/")
 *   .credentials(AzureCredential.DEFAULT)
 *   .build();
 * </pre>
 *
 * <p>The {@link HttpLogDetailLevel log detail level}, multiple custom {@link HttpLoggingPolicy policies} and custom
 * {@link HttpClient http client} can be optionally configured in the {@link SecretAsyncClientBuilder}.</p>
 * <pre>
 * SecretAsyncClient secretAsyncClient = SecretAsyncClient.builder()
 *   .vaultEndpoint("https://myvault.vault.azure.net/")
 *   .credentials(AzureCredential.DEFAULT)
 *   .httpLogDetailLevel(HttpLogDetailLevel.BODY_AND_HEADERS)
 *   .addPolicy(customPolicyOne)
 *   .addPolicy(customPolicyTwo)
 *   .httpClient(client)
 *   .build();
 * </pre>
 *
 * <p>Alternatively, custom {@link HttpPipeline http pipeline} with custom {@link HttpPipelinePolicy} policies and {@link String vaultEndpoint}
 * can be specified. It provides finer control over the construction of {@link SecretAsyncClient client}</p>
 * <pre>
 * SecretAsyncClient.builder()
 *   .pipeline(new HttpPipeline(customPoliciesList))
 *   .vaultEndpoint("https://myvault.vault.azure.net/")
 *   .build()
 * </pre>
 *
 * @see SecretAsyncClient
 */
public final class SecretAsyncClientBuilder {
    private final List<HttpPipelinePolicy> policies;
    private TokenCredential credentials;
    private HttpPipeline pipeline;
    private URL vaultEndpoint;
    private HttpClient httpClient;
    private HttpLogDetailLevel httpLogDetailLevel;
    private RetryPolicy retryPolicy;

    SecretAsyncClientBuilder() {
        retryPolicy = new RetryPolicy();
        httpLogDetailLevel = HttpLogDetailLevel.NONE;
        policies = new ArrayList<>();
    }

    /**
     * Creates a {@link SecretAsyncClient} based on options set in the builder.
     * Every time {@code build()} is called, a new instance of {@link SecretAsyncClient} is created.
     *
     * <p>If {@link SecretAsyncClientBuilder#pipeline(HttpPipeline) pipeline} is set, then the {@code pipeline} and
     * {@link SecretAsyncClientBuilder#vaultEndpoint(String) serviceEndpoint} are used to create the
     * {@link SecretAsyncClientBuilder client}. All other builder settings are ignored. If {@code pipeline} is not set,
     * then {@link SecretAsyncClientBuilder#credentials(TokenCredential) key vault credentials and
     * {@link SecretAsyncClientBuilder#vaultEndpoint(String)} key vault endpoint are required to build the {@link SecretAsyncClient client}.}</p>
     *
     * @return A SecretAsyncClient with the options set from the builder.
     * @throws IllegalStateException If {@link SecretAsyncClientBuilder#credentials(TokenCredential)} or
     * {@link SecretAsyncClientBuilder#vaultEndpoint(String)} have not been set.
     */
    public SecretAsyncClient build() {

        if (vaultEndpoint == null) {
            throw new IllegalStateException(KeyVaultErrorCodeStrings.getErrorString(KeyVaultErrorCodeStrings.VAULT_END_POINT_REQUIRED));
        }

        if (pipeline != null) {
            return new SecretAsyncClient(vaultEndpoint, pipeline);
        }

        if (credentials == null) {
            throw new IllegalStateException(KeyVaultErrorCodeStrings.getErrorString(KeyVaultErrorCodeStrings.CREDENTIALS_REQUIRED));
        }

        // Closest to API goes first, closest to wire goes last.
        final List<HttpPipelinePolicy> policies = new ArrayList<>();
        policies.add(new UserAgentPolicy(AzureKeyVaultConfiguration.SDK_NAME, AzureKeyVaultConfiguration.SDK_VERSION));
        policies.add(retryPolicy);
        policies.add(new KeyVaultCredentialPolicy(credentials));
        policies.addAll(this.policies);
        policies.add(new HttpLoggingPolicy(httpLogDetailLevel));

        HttpPipeline pipeline = httpClient == null
            ? new HttpPipeline(policies)
            : new HttpPipeline(httpClient, policies);

        return new SecretAsyncClient(vaultEndpoint, pipeline);
    }

    /**
     * Sets the vault endpoint url to send HTTP requests to.
     *
     * @param vaultEndPoint The vault endpoint url is used as destination on Azure to send requests to.
     * @return The updated Builder object.
     * @throws IllegalStateException if {@code vaultEndpoint} is null or it cannot be parsed into a valid URL.
     */
    public SecretAsyncClientBuilder vaultEndpoint(String vaultEndPoint) {
        try {
            this.vaultEndpoint = new URL(vaultEndPoint);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("The Azure Key Vault endpoint url is malformed.");
        }
        return this;
    }

    /**
     * Sets the credentials to use when authenticating HTTP requests.
     *
     * @param credentials The credentials to use for authenticating HTTP requests.
     * @return The updated Builder object.
     * @throws NullPointerException if {@code credentials} is {@code null}.
     */
    public SecretAsyncClientBuilder credentials(TokenCredential credentials) {
        Objects.requireNonNull(credentials);
        this.credentials = credentials;
        return this;
    }

    /**
     * Sets the logging level for HTTP requests and responses.
     *
     * <p>logLevel is optional. If not provided, default value of {@link HttpLogDetailLevel#NONE} is set.</p>
     *
     * @param logLevel The amount of logging output when sending and receiving HTTP requests/responses.
     * @return The updated Builder object.
     * @throws NullPointerException if {@code logLevel} is {@code null}.
     */
    public SecretAsyncClientBuilder httpLogDetailLevel(HttpLogDetailLevel logLevel) {
        Objects.requireNonNull(logLevel);
        httpLogDetailLevel = logLevel;
        return this;
    }

    /**
     * Adds a policy to the set of existing policies that are executed after
     * {@link SecretAsyncClient} required policies.
     *
     * @param policy The {@link HttpPipelinePolicy policy} to be added.
     * @return The updated Builder object.
     * @throws NullPointerException if {@code policy} is {@code null}.
     */
    public SecretAsyncClientBuilder addPolicy(HttpPipelinePolicy policy) {
        Objects.requireNonNull(policy);
        policies.add(policy);
        return this;
    }

    /**
     * Sets the HTTP client to use for sending and receiving requests to and from the service.
     *
     * @param client The HTTP client to use for requests.
     * @return The updated Builder object.
     * @throws NullPointerException If {@code client} is {@code null}.
     */
    public SecretAsyncClientBuilder httpClient(HttpClient client) {
        Objects.requireNonNull(client);
        this.httpClient = client;
        return this;
    }

    /**
     * Sets the HTTP pipeline to use for the service client.
     *
     * If {@code pipeline} is set, all other settings are ignored, aside from
     * {@link SecretAsyncClientBuilder#vaultEndpoint(String) vaultEndpoint} to build {@link SecretAsyncClient}.
     *
     * @param pipeline The HTTP pipeline to use for sending service requests and receiving responses.
     * @return The updated {@link SecretAsyncClientBuilder} object.
     */
    public SecretAsyncClientBuilder pipeline(HttpPipeline pipeline) {
        Objects.requireNonNull(pipeline);
        this.pipeline = pipeline;
        return this;
    }
}