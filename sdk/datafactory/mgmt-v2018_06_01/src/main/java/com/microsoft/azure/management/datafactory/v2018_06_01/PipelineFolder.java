/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datafactory.v2018_06_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The folder that this Pipeline is in. If not specified, Pipeline will appear
 * at the root level.
 */
public class PipelineFolder {
    /**
     * The name of the folder that this Pipeline is in.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * Get the name of the folder that this Pipeline is in.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name of the folder that this Pipeline is in.
     *
     * @param name the name value to set
     * @return the PipelineFolder object itself.
     */
    public PipelineFolder withName(String name) {
        this.name = name;
        return this;
    }

}
