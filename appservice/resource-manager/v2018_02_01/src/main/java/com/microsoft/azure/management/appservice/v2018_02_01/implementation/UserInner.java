/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice.v2018_02_01.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.management.appservice.v2018_02_01.ProxyOnlyResource;

/**
 * User crendentials used for publishing activity.
 */
@JsonFlatten
public class UserInner extends ProxyOnlyResource {
    /**
     * Username used for publishing.
     */
    @JsonProperty(value = "properties.publishingUserName", required = true)
    private String publishingUserName;

    /**
     * Password used for publishing.
     */
    @JsonProperty(value = "properties.publishingPassword")
    private String publishingPassword;

    /**
     * Password hash used for publishing.
     */
    @JsonProperty(value = "properties.publishingPasswordHash")
    private String publishingPasswordHash;

    /**
     * Password hash salt used for publishing.
     */
    @JsonProperty(value = "properties.publishingPasswordHashSalt")
    private String publishingPasswordHashSalt;

    /**
     * Url of SCM site.
     */
    @JsonProperty(value = "properties.scmUri")
    private String scmUri;

    /**
     * Get username used for publishing.
     *
     * @return the publishingUserName value
     */
    public String publishingUserName() {
        return this.publishingUserName;
    }

    /**
     * Set username used for publishing.
     *
     * @param publishingUserName the publishingUserName value to set
     * @return the UserInner object itself.
     */
    public UserInner withPublishingUserName(String publishingUserName) {
        this.publishingUserName = publishingUserName;
        return this;
    }

    /**
     * Get password used for publishing.
     *
     * @return the publishingPassword value
     */
    public String publishingPassword() {
        return this.publishingPassword;
    }

    /**
     * Set password used for publishing.
     *
     * @param publishingPassword the publishingPassword value to set
     * @return the UserInner object itself.
     */
    public UserInner withPublishingPassword(String publishingPassword) {
        this.publishingPassword = publishingPassword;
        return this;
    }

    /**
     * Get password hash used for publishing.
     *
     * @return the publishingPasswordHash value
     */
    public String publishingPasswordHash() {
        return this.publishingPasswordHash;
    }

    /**
     * Set password hash used for publishing.
     *
     * @param publishingPasswordHash the publishingPasswordHash value to set
     * @return the UserInner object itself.
     */
    public UserInner withPublishingPasswordHash(String publishingPasswordHash) {
        this.publishingPasswordHash = publishingPasswordHash;
        return this;
    }

    /**
     * Get password hash salt used for publishing.
     *
     * @return the publishingPasswordHashSalt value
     */
    public String publishingPasswordHashSalt() {
        return this.publishingPasswordHashSalt;
    }

    /**
     * Set password hash salt used for publishing.
     *
     * @param publishingPasswordHashSalt the publishingPasswordHashSalt value to set
     * @return the UserInner object itself.
     */
    public UserInner withPublishingPasswordHashSalt(String publishingPasswordHashSalt) {
        this.publishingPasswordHashSalt = publishingPasswordHashSalt;
        return this;
    }

    /**
     * Get url of SCM site.
     *
     * @return the scmUri value
     */
    public String scmUri() {
        return this.scmUri;
    }

    /**
     * Set url of SCM site.
     *
     * @param scmUri the scmUri value to set
     * @return the UserInner object itself.
     */
    public UserInner withScmUri(String scmUri) {
        this.scmUri = scmUri;
        return this;
    }

}