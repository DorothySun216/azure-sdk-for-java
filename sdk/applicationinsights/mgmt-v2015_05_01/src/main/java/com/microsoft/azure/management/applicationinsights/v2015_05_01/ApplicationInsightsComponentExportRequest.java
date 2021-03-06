/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.applicationinsights.v2015_05_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An Application Insights component Continuous Export configuration request
 * definition.
 */
public class ApplicationInsightsComponentExportRequest {
    /**
     * The document types to be exported, as comma separated values. Allowed
     * values include 'Requests', 'Event', 'Exceptions', 'Metrics',
     * 'PageViews', 'PageViewPerformance', 'Rdd', 'PerformanceCounters',
     * 'Availability', 'Messages'.
     */
    @JsonProperty(value = "RecordTypes")
    private String recordTypes;

    /**
     * The Continuous Export destination type. This has to be 'Blob'.
     */
    @JsonProperty(value = "DestinationType")
    private String destinationType;

    /**
     * The SAS URL for the destination storage container. It must grant write
     * permission.
     */
    @JsonProperty(value = "DestinationAddress")
    private String destinationAddress;

    /**
     * Set to 'true' to create a Continuous Export configuration as enabled,
     * otherwise set it to 'false'.
     */
    @JsonProperty(value = "IsEnabled")
    private String isEnabled;

    /**
     * Deprecated.
     */
    @JsonProperty(value = "NotificationQueueEnabled")
    private String notificationQueueEnabled;

    /**
     * Deprecated.
     */
    @JsonProperty(value = "NotificationQueueUri")
    private String notificationQueueUri;

    /**
     * The subscription ID of the destination storage container.
     */
    @JsonProperty(value = "DestinationStorageSubscriptionId")
    private String destinationStorageSubscriptionId;

    /**
     * The location ID of the destination storage container.
     */
    @JsonProperty(value = "DestinationStorageLocationId")
    private String destinationStorageLocationId;

    /**
     * The name of destination storage account.
     */
    @JsonProperty(value = "DestinationAccountId")
    private String destinationAccountId;

    /**
     * Get the document types to be exported, as comma separated values. Allowed values include 'Requests', 'Event', 'Exceptions', 'Metrics', 'PageViews', 'PageViewPerformance', 'Rdd', 'PerformanceCounters', 'Availability', 'Messages'.
     *
     * @return the recordTypes value
     */
    public String recordTypes() {
        return this.recordTypes;
    }

    /**
     * Set the document types to be exported, as comma separated values. Allowed values include 'Requests', 'Event', 'Exceptions', 'Metrics', 'PageViews', 'PageViewPerformance', 'Rdd', 'PerformanceCounters', 'Availability', 'Messages'.
     *
     * @param recordTypes the recordTypes value to set
     * @return the ApplicationInsightsComponentExportRequest object itself.
     */
    public ApplicationInsightsComponentExportRequest withRecordTypes(String recordTypes) {
        this.recordTypes = recordTypes;
        return this;
    }

    /**
     * Get the Continuous Export destination type. This has to be 'Blob'.
     *
     * @return the destinationType value
     */
    public String destinationType() {
        return this.destinationType;
    }

    /**
     * Set the Continuous Export destination type. This has to be 'Blob'.
     *
     * @param destinationType the destinationType value to set
     * @return the ApplicationInsightsComponentExportRequest object itself.
     */
    public ApplicationInsightsComponentExportRequest withDestinationType(String destinationType) {
        this.destinationType = destinationType;
        return this;
    }

    /**
     * Get the SAS URL for the destination storage container. It must grant write permission.
     *
     * @return the destinationAddress value
     */
    public String destinationAddress() {
        return this.destinationAddress;
    }

    /**
     * Set the SAS URL for the destination storage container. It must grant write permission.
     *
     * @param destinationAddress the destinationAddress value to set
     * @return the ApplicationInsightsComponentExportRequest object itself.
     */
    public ApplicationInsightsComponentExportRequest withDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
        return this;
    }

    /**
     * Get set to 'true' to create a Continuous Export configuration as enabled, otherwise set it to 'false'.
     *
     * @return the isEnabled value
     */
    public String isEnabled() {
        return this.isEnabled;
    }

    /**
     * Set set to 'true' to create a Continuous Export configuration as enabled, otherwise set it to 'false'.
     *
     * @param isEnabled the isEnabled value to set
     * @return the ApplicationInsightsComponentExportRequest object itself.
     */
    public ApplicationInsightsComponentExportRequest withIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled;
        return this;
    }

    /**
     * Get deprecated.
     *
     * @return the notificationQueueEnabled value
     */
    public String notificationQueueEnabled() {
        return this.notificationQueueEnabled;
    }

    /**
     * Set deprecated.
     *
     * @param notificationQueueEnabled the notificationQueueEnabled value to set
     * @return the ApplicationInsightsComponentExportRequest object itself.
     */
    public ApplicationInsightsComponentExportRequest withNotificationQueueEnabled(String notificationQueueEnabled) {
        this.notificationQueueEnabled = notificationQueueEnabled;
        return this;
    }

    /**
     * Get deprecated.
     *
     * @return the notificationQueueUri value
     */
    public String notificationQueueUri() {
        return this.notificationQueueUri;
    }

    /**
     * Set deprecated.
     *
     * @param notificationQueueUri the notificationQueueUri value to set
     * @return the ApplicationInsightsComponentExportRequest object itself.
     */
    public ApplicationInsightsComponentExportRequest withNotificationQueueUri(String notificationQueueUri) {
        this.notificationQueueUri = notificationQueueUri;
        return this;
    }

    /**
     * Get the subscription ID of the destination storage container.
     *
     * @return the destinationStorageSubscriptionId value
     */
    public String destinationStorageSubscriptionId() {
        return this.destinationStorageSubscriptionId;
    }

    /**
     * Set the subscription ID of the destination storage container.
     *
     * @param destinationStorageSubscriptionId the destinationStorageSubscriptionId value to set
     * @return the ApplicationInsightsComponentExportRequest object itself.
     */
    public ApplicationInsightsComponentExportRequest withDestinationStorageSubscriptionId(String destinationStorageSubscriptionId) {
        this.destinationStorageSubscriptionId = destinationStorageSubscriptionId;
        return this;
    }

    /**
     * Get the location ID of the destination storage container.
     *
     * @return the destinationStorageLocationId value
     */
    public String destinationStorageLocationId() {
        return this.destinationStorageLocationId;
    }

    /**
     * Set the location ID of the destination storage container.
     *
     * @param destinationStorageLocationId the destinationStorageLocationId value to set
     * @return the ApplicationInsightsComponentExportRequest object itself.
     */
    public ApplicationInsightsComponentExportRequest withDestinationStorageLocationId(String destinationStorageLocationId) {
        this.destinationStorageLocationId = destinationStorageLocationId;
        return this;
    }

    /**
     * Get the name of destination storage account.
     *
     * @return the destinationAccountId value
     */
    public String destinationAccountId() {
        return this.destinationAccountId;
    }

    /**
     * Set the name of destination storage account.
     *
     * @param destinationAccountId the destinationAccountId value to set
     * @return the ApplicationInsightsComponentExportRequest object itself.
     */
    public ApplicationInsightsComponentExportRequest withDestinationAccountId(String destinationAccountId) {
        this.destinationAccountId = destinationAccountId;
        return this;
    }

}
