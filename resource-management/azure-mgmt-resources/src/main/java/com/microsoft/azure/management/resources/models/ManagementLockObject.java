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

package com.microsoft.azure.management.resources.models;

/**
* Management lock information.
*/
public class ManagementLockObject {
    private String id;
    
    /**
    * Optional. Gets or sets the Id of the lock.
    * @return The Id value.
    */
    public String getId() {
        return this.id;
    }
    
    /**
    * Optional. Gets or sets the Id of the lock.
    * @param idValue The Id value.
    */
    public void setId(final String idValue) {
        this.id = idValue;
    }
    
    private String name;
    
    /**
    * Optional. Gets or sets the name of the lock.
    * @return The Name value.
    */
    public String getName() {
        return this.name;
    }
    
    /**
    * Optional. Gets or sets the name of the lock.
    * @param nameValue The Name value.
    */
    public void setName(final String nameValue) {
        this.name = nameValue;
    }
    
    private ManagementLockProperties properties;
    
    /**
    * Optional. Gets or sets the properties of the lock.
    * @return The Properties value.
    */
    public ManagementLockProperties getProperties() {
        return this.properties;
    }
    
    /**
    * Optional. Gets or sets the properties of the lock.
    * @param propertiesValue The Properties value.
    */
    public void setProperties(final ManagementLockProperties propertiesValue) {
        this.properties = propertiesValue;
    }
    
    private String type;
    
    /**
    * Optional. Gets or sets the type of the lock.
    * @return The Type value.
    */
    public String getType() {
        return this.type;
    }
    
    /**
    * Optional. Gets or sets the type of the lock.
    * @param typeValue The Type value.
    */
    public void setType(final String typeValue) {
        this.type = typeValue;
    }
}
