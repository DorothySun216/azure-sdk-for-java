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

package com.microsoft.azure.management.websites.models;

/**
* Historical metric snapshot for the web site.
*/
public class HistoricalUsageMetric {
    private String code;
    
    /**
    * Optional. Reports whether the metric data was returned successfully.
    * @return The Code value.
    */
    public String getCode() {
        return this.code;
    }
    
    /**
    * Optional. Reports whether the metric data was returned successfully.
    * @param codeValue The Code value.
    */
    public void setCode(final String codeValue) {
        this.code = codeValue;
    }
    
    private HistoricalUsageMetricData data;
    
    /**
    * Optional. Historical metric snapshot data for the web site.
    * @return The Data value.
    */
    public HistoricalUsageMetricData getData() {
        return this.data;
    }
    
    /**
    * Optional. Historical metric snapshot data for the web site.
    * @param dataValue The Data value.
    */
    public void setData(final HistoricalUsageMetricData dataValue) {
        this.data = dataValue;
    }
    
    private String message;
    
    /**
    * Optional. A string for optional message content.
    * @return The Message value.
    */
    public String getMessage() {
        return this.message;
    }
    
    /**
    * Optional. A string for optional message content.
    * @param messageValue The Message value.
    */
    public void setMessage(final String messageValue) {
        this.message = messageValue;
    }
}
