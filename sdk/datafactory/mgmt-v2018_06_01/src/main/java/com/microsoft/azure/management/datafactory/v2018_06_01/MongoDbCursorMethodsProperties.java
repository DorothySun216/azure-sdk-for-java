/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datafactory.v2018_06_01;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Cursor methods for Mongodb query.
 */
public class MongoDbCursorMethodsProperties {
    /**
     * Unmatched properties from the message are deserialized this collection.
     */
    @JsonProperty(value = "")
    private Map<String, Object> additionalProperties;

    /**
     * Specifies the fields to return in the documents that match the query
     * filter. To return all fields in the matching documents, omit this
     * parameter. Type: string (or Expression with resultType string).
     */
    @JsonProperty(value = "project")
    private Object project;

    /**
     * Specifies the order in which the query returns matching documents. Type:
     * string (or Expression with resultType string). Type: string (or
     * Expression with resultType string).
     */
    @JsonProperty(value = "sort")
    private Object sort;

    /**
     * Specifies the how many documents skipped and where MongoDB begins
     * returning results. This approach may be useful in implementing paginated
     * results. Type: integer (or Expression with resultType integer).
     */
    @JsonProperty(value = "skip")
    private Object skip;

    /**
     * Specifies the maximum number of documents the server returns. limit() is
     * analogous to the LIMIT statement in a SQL database. Type: integer (or
     * Expression with resultType integer).
     */
    @JsonProperty(value = "limit")
    private Object limit;

    /**
     * Get unmatched properties from the message are deserialized this collection.
     *
     * @return the additionalProperties value
     */
    public Map<String, Object> additionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set unmatched properties from the message are deserialized this collection.
     *
     * @param additionalProperties the additionalProperties value to set
     * @return the MongoDbCursorMethodsProperties object itself.
     */
    public MongoDbCursorMethodsProperties withAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    /**
     * Get specifies the fields to return in the documents that match the query filter. To return all fields in the matching documents, omit this parameter. Type: string (or Expression with resultType string).
     *
     * @return the project value
     */
    public Object project() {
        return this.project;
    }

    /**
     * Set specifies the fields to return in the documents that match the query filter. To return all fields in the matching documents, omit this parameter. Type: string (or Expression with resultType string).
     *
     * @param project the project value to set
     * @return the MongoDbCursorMethodsProperties object itself.
     */
    public MongoDbCursorMethodsProperties withProject(Object project) {
        this.project = project;
        return this;
    }

    /**
     * Get specifies the order in which the query returns matching documents. Type: string (or Expression with resultType string). Type: string (or Expression with resultType string).
     *
     * @return the sort value
     */
    public Object sort() {
        return this.sort;
    }

    /**
     * Set specifies the order in which the query returns matching documents. Type: string (or Expression with resultType string). Type: string (or Expression with resultType string).
     *
     * @param sort the sort value to set
     * @return the MongoDbCursorMethodsProperties object itself.
     */
    public MongoDbCursorMethodsProperties withSort(Object sort) {
        this.sort = sort;
        return this;
    }

    /**
     * Get specifies the how many documents skipped and where MongoDB begins returning results. This approach may be useful in implementing paginated results. Type: integer (or Expression with resultType integer).
     *
     * @return the skip value
     */
    public Object skip() {
        return this.skip;
    }

    /**
     * Set specifies the how many documents skipped and where MongoDB begins returning results. This approach may be useful in implementing paginated results. Type: integer (or Expression with resultType integer).
     *
     * @param skip the skip value to set
     * @return the MongoDbCursorMethodsProperties object itself.
     */
    public MongoDbCursorMethodsProperties withSkip(Object skip) {
        this.skip = skip;
        return this;
    }

    /**
     * Get specifies the maximum number of documents the server returns. limit() is analogous to the LIMIT statement in a SQL database. Type: integer (or Expression with resultType integer).
     *
     * @return the limit value
     */
    public Object limit() {
        return this.limit;
    }

    /**
     * Set specifies the maximum number of documents the server returns. limit() is analogous to the LIMIT statement in a SQL database. Type: integer (or Expression with resultType integer).
     *
     * @param limit the limit value to set
     * @return the MongoDbCursorMethodsProperties object itself.
     */
    public MongoDbCursorMethodsProperties withLimit(Object limit) {
        this.limit = limit;
        return this;
    }

}
