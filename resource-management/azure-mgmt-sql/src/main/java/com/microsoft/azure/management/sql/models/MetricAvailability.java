/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.azure.management.sql.models;

/**
* Represents an Azure SQL Database Elastic Pool metric availability.
*/
public class MetricAvailability {
    private String retention;
    
    /**
    * Optional. Gets or sets the retention period for the metric.
    * @return The Retention value.
    */
    public String getRetention() {
        return this.retention;
    }
    
    /**
    * Optional. Gets or sets the retention period for the metric.
    * @param retentionValue The Retention value.
    */
    public void setRetention(final String retentionValue) {
        this.retention = retentionValue;
    }
    
    private String timeGrain;
    
    /**
    * Optional. Gets or sets the time grain for the metric.
    * @return The TimeGrain value.
    */
    public String getTimeGrain() {
        return this.timeGrain;
    }
    
    /**
    * Optional. Gets or sets the time grain for the metric.
    * @param timeGrainValue The TimeGrain value.
    */
    public void setTimeGrain(final String timeGrainValue) {
        this.timeGrain = timeGrainValue;
    }
}
