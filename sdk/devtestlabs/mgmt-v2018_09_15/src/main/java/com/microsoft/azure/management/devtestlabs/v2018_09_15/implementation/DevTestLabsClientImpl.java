/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.devtestlabs.v2018_09_15.implementation;

import com.microsoft.azure.AzureClient;
import com.microsoft.azure.AzureServiceClient;
import com.microsoft.rest.credentials.ServiceClientCredentials;
import com.microsoft.rest.RestClient;

/**
 * Initializes a new instance of the DevTestLabsClientImpl class.
 */
public class DevTestLabsClientImpl extends AzureServiceClient {
    /** the {@link AzureClient} used for long running operations. */
    private AzureClient azureClient;

    /**
     * Gets the {@link AzureClient} used for long running operations.
     * @return the azure client;
     */
    public AzureClient getAzureClient() {
        return this.azureClient;
    }

    /** Client API version. */
    private String apiVersion;

    /**
     * Gets Client API version.
     *
     * @return the apiVersion value.
     */
    public String apiVersion() {
        return this.apiVersion;
    }

    /** The subscription ID. */
    private String subscriptionId;

    /**
     * Gets The subscription ID.
     *
     * @return the subscriptionId value.
     */
    public String subscriptionId() {
        return this.subscriptionId;
    }

    /**
     * Sets The subscription ID.
     *
     * @param subscriptionId the subscriptionId value.
     * @return the service client itself
     */
    public DevTestLabsClientImpl withSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }

    /** The preferred language for the response. */
    private String acceptLanguage;

    /**
     * Gets The preferred language for the response.
     *
     * @return the acceptLanguage value.
     */
    public String acceptLanguage() {
        return this.acceptLanguage;
    }

    /**
     * Sets The preferred language for the response.
     *
     * @param acceptLanguage the acceptLanguage value.
     * @return the service client itself
     */
    public DevTestLabsClientImpl withAcceptLanguage(String acceptLanguage) {
        this.acceptLanguage = acceptLanguage;
        return this;
    }

    /** The retry timeout in seconds for Long Running Operations. Default value is 30. */
    private int longRunningOperationRetryTimeout;

    /**
     * Gets The retry timeout in seconds for Long Running Operations. Default value is 30.
     *
     * @return the longRunningOperationRetryTimeout value.
     */
    public int longRunningOperationRetryTimeout() {
        return this.longRunningOperationRetryTimeout;
    }

    /**
     * Sets The retry timeout in seconds for Long Running Operations. Default value is 30.
     *
     * @param longRunningOperationRetryTimeout the longRunningOperationRetryTimeout value.
     * @return the service client itself
     */
    public DevTestLabsClientImpl withLongRunningOperationRetryTimeout(int longRunningOperationRetryTimeout) {
        this.longRunningOperationRetryTimeout = longRunningOperationRetryTimeout;
        return this;
    }

    /** Whether a unique x-ms-client-request-id should be generated. When set to true a unique x-ms-client-request-id value is generated and included in each request. Default is true. */
    private boolean generateClientRequestId;

    /**
     * Gets Whether a unique x-ms-client-request-id should be generated. When set to true a unique x-ms-client-request-id value is generated and included in each request. Default is true.
     *
     * @return the generateClientRequestId value.
     */
    public boolean generateClientRequestId() {
        return this.generateClientRequestId;
    }

    /**
     * Sets Whether a unique x-ms-client-request-id should be generated. When set to true a unique x-ms-client-request-id value is generated and included in each request. Default is true.
     *
     * @param generateClientRequestId the generateClientRequestId value.
     * @return the service client itself
     */
    public DevTestLabsClientImpl withGenerateClientRequestId(boolean generateClientRequestId) {
        this.generateClientRequestId = generateClientRequestId;
        return this;
    }

    /**
     * The ProviderOperationsInner object to access its operations.
     */
    private ProviderOperationsInner providerOperations;

    /**
     * Gets the ProviderOperationsInner object to access its operations.
     * @return the ProviderOperationsInner object.
     */
    public ProviderOperationsInner providerOperations() {
        return this.providerOperations;
    }

    /**
     * The LabsInner object to access its operations.
     */
    private LabsInner labs;

    /**
     * Gets the LabsInner object to access its operations.
     * @return the LabsInner object.
     */
    public LabsInner labs() {
        return this.labs;
    }

    /**
     * The OperationsInner object to access its operations.
     */
    private OperationsInner operations;

    /**
     * Gets the OperationsInner object to access its operations.
     * @return the OperationsInner object.
     */
    public OperationsInner operations() {
        return this.operations;
    }

    /**
     * The GlobalSchedulesInner object to access its operations.
     */
    private GlobalSchedulesInner globalSchedules;

    /**
     * Gets the GlobalSchedulesInner object to access its operations.
     * @return the GlobalSchedulesInner object.
     */
    public GlobalSchedulesInner globalSchedules() {
        return this.globalSchedules;
    }

    /**
     * The ArtifactSourcesInner object to access its operations.
     */
    private ArtifactSourcesInner artifactSources;

    /**
     * Gets the ArtifactSourcesInner object to access its operations.
     * @return the ArtifactSourcesInner object.
     */
    public ArtifactSourcesInner artifactSources() {
        return this.artifactSources;
    }

    /**
     * The ArmTemplatesInner object to access its operations.
     */
    private ArmTemplatesInner armTemplates;

    /**
     * Gets the ArmTemplatesInner object to access its operations.
     * @return the ArmTemplatesInner object.
     */
    public ArmTemplatesInner armTemplates() {
        return this.armTemplates;
    }

    /**
     * The ArtifactsInner object to access its operations.
     */
    private ArtifactsInner artifacts;

    /**
     * Gets the ArtifactsInner object to access its operations.
     * @return the ArtifactsInner object.
     */
    public ArtifactsInner artifacts() {
        return this.artifacts;
    }

    /**
     * The CostsInner object to access its operations.
     */
    private CostsInner costs;

    /**
     * Gets the CostsInner object to access its operations.
     * @return the CostsInner object.
     */
    public CostsInner costs() {
        return this.costs;
    }

    /**
     * The CustomImagesInner object to access its operations.
     */
    private CustomImagesInner customImages;

    /**
     * Gets the CustomImagesInner object to access its operations.
     * @return the CustomImagesInner object.
     */
    public CustomImagesInner customImages() {
        return this.customImages;
    }

    /**
     * The FormulasInner object to access its operations.
     */
    private FormulasInner formulas;

    /**
     * Gets the FormulasInner object to access its operations.
     * @return the FormulasInner object.
     */
    public FormulasInner formulas() {
        return this.formulas;
    }

    /**
     * The GalleryImagesInner object to access its operations.
     */
    private GalleryImagesInner galleryImages;

    /**
     * Gets the GalleryImagesInner object to access its operations.
     * @return the GalleryImagesInner object.
     */
    public GalleryImagesInner galleryImages() {
        return this.galleryImages;
    }

    /**
     * The NotificationChannelsInner object to access its operations.
     */
    private NotificationChannelsInner notificationChannels;

    /**
     * Gets the NotificationChannelsInner object to access its operations.
     * @return the NotificationChannelsInner object.
     */
    public NotificationChannelsInner notificationChannels() {
        return this.notificationChannels;
    }

    /**
     * The PolicySetsInner object to access its operations.
     */
    private PolicySetsInner policySets;

    /**
     * Gets the PolicySetsInner object to access its operations.
     * @return the PolicySetsInner object.
     */
    public PolicySetsInner policySets() {
        return this.policySets;
    }

    /**
     * The PoliciesInner object to access its operations.
     */
    private PoliciesInner policies;

    /**
     * Gets the PoliciesInner object to access its operations.
     * @return the PoliciesInner object.
     */
    public PoliciesInner policies() {
        return this.policies;
    }

    /**
     * The SchedulesInner object to access its operations.
     */
    private SchedulesInner schedules;

    /**
     * Gets the SchedulesInner object to access its operations.
     * @return the SchedulesInner object.
     */
    public SchedulesInner schedules() {
        return this.schedules;
    }

    /**
     * The ServiceRunnersInner object to access its operations.
     */
    private ServiceRunnersInner serviceRunners;

    /**
     * Gets the ServiceRunnersInner object to access its operations.
     * @return the ServiceRunnersInner object.
     */
    public ServiceRunnersInner serviceRunners() {
        return this.serviceRunners;
    }

    /**
     * The UsersInner object to access its operations.
     */
    private UsersInner users;

    /**
     * Gets the UsersInner object to access its operations.
     * @return the UsersInner object.
     */
    public UsersInner users() {
        return this.users;
    }

    /**
     * The DisksInner object to access its operations.
     */
    private DisksInner disks;

    /**
     * Gets the DisksInner object to access its operations.
     * @return the DisksInner object.
     */
    public DisksInner disks() {
        return this.disks;
    }

    /**
     * The EnvironmentsInner object to access its operations.
     */
    private EnvironmentsInner environments;

    /**
     * Gets the EnvironmentsInner object to access its operations.
     * @return the EnvironmentsInner object.
     */
    public EnvironmentsInner environments() {
        return this.environments;
    }

    /**
     * The SecretsInner object to access its operations.
     */
    private SecretsInner secrets;

    /**
     * Gets the SecretsInner object to access its operations.
     * @return the SecretsInner object.
     */
    public SecretsInner secrets() {
        return this.secrets;
    }

    /**
     * The ServiceFabricsInner object to access its operations.
     */
    private ServiceFabricsInner serviceFabrics;

    /**
     * Gets the ServiceFabricsInner object to access its operations.
     * @return the ServiceFabricsInner object.
     */
    public ServiceFabricsInner serviceFabrics() {
        return this.serviceFabrics;
    }

    /**
     * The ServiceFabricSchedulesInner object to access its operations.
     */
    private ServiceFabricSchedulesInner serviceFabricSchedules;

    /**
     * Gets the ServiceFabricSchedulesInner object to access its operations.
     * @return the ServiceFabricSchedulesInner object.
     */
    public ServiceFabricSchedulesInner serviceFabricSchedules() {
        return this.serviceFabricSchedules;
    }

    /**
     * The VirtualMachinesInner object to access its operations.
     */
    private VirtualMachinesInner virtualMachines;

    /**
     * Gets the VirtualMachinesInner object to access its operations.
     * @return the VirtualMachinesInner object.
     */
    public VirtualMachinesInner virtualMachines() {
        return this.virtualMachines;
    }

    /**
     * The VirtualMachineSchedulesInner object to access its operations.
     */
    private VirtualMachineSchedulesInner virtualMachineSchedules;

    /**
     * Gets the VirtualMachineSchedulesInner object to access its operations.
     * @return the VirtualMachineSchedulesInner object.
     */
    public VirtualMachineSchedulesInner virtualMachineSchedules() {
        return this.virtualMachineSchedules;
    }

    /**
     * The VirtualNetworksInner object to access its operations.
     */
    private VirtualNetworksInner virtualNetworks;

    /**
     * Gets the VirtualNetworksInner object to access its operations.
     * @return the VirtualNetworksInner object.
     */
    public VirtualNetworksInner virtualNetworks() {
        return this.virtualNetworks;
    }

    /**
     * Initializes an instance of DevTestLabsClient client.
     *
     * @param credentials the management credentials for Azure
     */
    public DevTestLabsClientImpl(ServiceClientCredentials credentials) {
        this("https://management.azure.com", credentials);
    }

    /**
     * Initializes an instance of DevTestLabsClient client.
     *
     * @param baseUrl the base URL of the host
     * @param credentials the management credentials for Azure
     */
    public DevTestLabsClientImpl(String baseUrl, ServiceClientCredentials credentials) {
        super(baseUrl, credentials);
        initialize();
    }

    /**
     * Initializes an instance of DevTestLabsClient client.
     *
     * @param restClient the REST client to connect to Azure.
     */
    public DevTestLabsClientImpl(RestClient restClient) {
        super(restClient);
        initialize();
    }

    protected void initialize() {
        this.apiVersion = "2018-09-15";
        this.acceptLanguage = "en-US";
        this.longRunningOperationRetryTimeout = 30;
        this.generateClientRequestId = true;
        this.providerOperations = new ProviderOperationsInner(restClient().retrofit(), this);
        this.labs = new LabsInner(restClient().retrofit(), this);
        this.operations = new OperationsInner(restClient().retrofit(), this);
        this.globalSchedules = new GlobalSchedulesInner(restClient().retrofit(), this);
        this.artifactSources = new ArtifactSourcesInner(restClient().retrofit(), this);
        this.armTemplates = new ArmTemplatesInner(restClient().retrofit(), this);
        this.artifacts = new ArtifactsInner(restClient().retrofit(), this);
        this.costs = new CostsInner(restClient().retrofit(), this);
        this.customImages = new CustomImagesInner(restClient().retrofit(), this);
        this.formulas = new FormulasInner(restClient().retrofit(), this);
        this.galleryImages = new GalleryImagesInner(restClient().retrofit(), this);
        this.notificationChannels = new NotificationChannelsInner(restClient().retrofit(), this);
        this.policySets = new PolicySetsInner(restClient().retrofit(), this);
        this.policies = new PoliciesInner(restClient().retrofit(), this);
        this.schedules = new SchedulesInner(restClient().retrofit(), this);
        this.serviceRunners = new ServiceRunnersInner(restClient().retrofit(), this);
        this.users = new UsersInner(restClient().retrofit(), this);
        this.disks = new DisksInner(restClient().retrofit(), this);
        this.environments = new EnvironmentsInner(restClient().retrofit(), this);
        this.secrets = new SecretsInner(restClient().retrofit(), this);
        this.serviceFabrics = new ServiceFabricsInner(restClient().retrofit(), this);
        this.serviceFabricSchedules = new ServiceFabricSchedulesInner(restClient().retrofit(), this);
        this.virtualMachines = new VirtualMachinesInner(restClient().retrofit(), this);
        this.virtualMachineSchedules = new VirtualMachineSchedulesInner(restClient().retrofit(), this);
        this.virtualNetworks = new VirtualNetworksInner(restClient().retrofit(), this);
        this.azureClient = new AzureClient(this);
    }

    /**
     * Gets the User-Agent header for the client.
     *
     * @return the user agent string.
     */
    @Override
    public String userAgent() {
        return String.format("%s (%s, %s, auto-generated)", super.userAgent(), "DevTestLabsClient", "2018-09-15");
    }
}
