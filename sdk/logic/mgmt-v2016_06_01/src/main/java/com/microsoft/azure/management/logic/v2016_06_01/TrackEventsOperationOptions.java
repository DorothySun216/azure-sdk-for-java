/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.logic.v2016_06_01;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for TrackEventsOperationOptions.
 */
public enum TrackEventsOperationOptions {
    /** Enum value None. */
    NONE("None"),

    /** Enum value DisableSourceInfoEnrich. */
    DISABLE_SOURCE_INFO_ENRICH("DisableSourceInfoEnrich");

    /** The actual serialized value for a TrackEventsOperationOptions instance. */
    private String value;

    TrackEventsOperationOptions(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a TrackEventsOperationOptions instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed TrackEventsOperationOptions object, or null if unable to parse.
     */
    @JsonCreator
    public static TrackEventsOperationOptions fromString(String value) {
        TrackEventsOperationOptions[] items = TrackEventsOperationOptions.values();
        for (TrackEventsOperationOptions item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
