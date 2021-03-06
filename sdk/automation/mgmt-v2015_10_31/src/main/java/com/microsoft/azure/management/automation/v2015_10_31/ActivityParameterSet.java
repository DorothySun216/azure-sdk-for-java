/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.automation.v2015_10_31;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Definition of the activity parameter set.
 */
public class ActivityParameterSet {
    /**
     * Gets or sets the name of the activity parameter set.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * Gets or sets the parameters of the activity parameter set.
     */
    @JsonProperty(value = "parameters")
    private List<ActivityParameter> parameters;

    /**
     * Get gets or sets the name of the activity parameter set.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set gets or sets the name of the activity parameter set.
     *
     * @param name the name value to set
     * @return the ActivityParameterSet object itself.
     */
    public ActivityParameterSet withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get gets or sets the parameters of the activity parameter set.
     *
     * @return the parameters value
     */
    public List<ActivityParameter> parameters() {
        return this.parameters;
    }

    /**
     * Set gets or sets the parameters of the activity parameter set.
     *
     * @param parameters the parameters value to set
     * @return the ActivityParameterSet object itself.
     */
    public ActivityParameterSet withParameters(List<ActivityParameter> parameters) {
        this.parameters = parameters;
        return this;
    }

}
