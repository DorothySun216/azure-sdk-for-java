/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.apimanagement.v2019_12_01.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.ProxyResource;

/**
 * Recipient Email details.
 */
@JsonFlatten
public class RecipientEmailContractInner extends ProxyResource {
    /**
     * User Email subscribed to notification.
     */
    @JsonProperty(value = "properties.email")
    private String email;

    /**
     * Get user Email subscribed to notification.
     *
     * @return the email value
     */
    public String email() {
        return this.email;
    }

    /**
     * Set user Email subscribed to notification.
     *
     * @param email the email value to set
     * @return the RecipientEmailContractInner object itself.
     */
    public RecipientEmailContractInner withEmail(String email) {
        this.email = email;
        return this;
    }

}
