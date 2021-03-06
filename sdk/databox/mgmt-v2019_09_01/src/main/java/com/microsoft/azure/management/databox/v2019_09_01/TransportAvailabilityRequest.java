/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.databox.v2019_09_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request body to get the transport availability for given sku.
 */
public class TransportAvailabilityRequest {
    /**
     * Type of the device. Possible values include: 'DataBox', 'DataBoxDisk',
     * 'DataBoxHeavy'.
     */
    @JsonProperty(value = "skuName")
    private SkuName skuName;

    /**
     * Get type of the device. Possible values include: 'DataBox', 'DataBoxDisk', 'DataBoxHeavy'.
     *
     * @return the skuName value
     */
    public SkuName skuName() {
        return this.skuName;
    }

    /**
     * Set type of the device. Possible values include: 'DataBox', 'DataBoxDisk', 'DataBoxHeavy'.
     *
     * @param skuName the skuName value to set
     * @return the TransportAvailabilityRequest object itself.
     */
    public TransportAvailabilityRequest withSkuName(SkuName skuName) {
        this.skuName = skuName;
        return this;
    }

}
