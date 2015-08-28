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

package com.microsoft.windowsazure.management.network.models;

import com.microsoft.windowsazure.core.LazyArrayList;
import com.microsoft.windowsazure.core.OperationResponse;
import java.util.ArrayList;

/**
* The response body contains details of the application gateway.
*/
public class ApplicationGatewayGetResponse extends OperationResponse {
    private String description;
    
    /**
    * Optional. User supplied description of the gateway
    * @return The Description value.
    */
    public String getDescription() {
        return this.description;
    }
    
    /**
    * Optional. User supplied description of the gateway
    * @param descriptionValue The Description value.
    */
    public void setDescription(final String descriptionValue) {
        this.description = descriptionValue;
    }
    
    private String dnsName;
    
    /**
    * Optional. DNS name for the gateay.
    * @return The DnsName value.
    */
    public String getDnsName() {
        return this.dnsName;
    }
    
    /**
    * Optional. DNS name for the gateay.
    * @param dnsNameValue The DnsName value.
    */
    public void setDnsName(final String dnsNameValue) {
        this.dnsName = dnsNameValue;
    }
    
    private String gatewaySize;
    
    /**
    * Optional. The size of each gateway instance.
    * @return The GatewaySize value.
    */
    public String getGatewaySize() {
        return this.gatewaySize;
    }
    
    /**
    * Optional. The size of each gateway instance.
    * @param gatewaySizeValue The GatewaySize value.
    */
    public void setGatewaySize(final String gatewaySizeValue) {
        this.gatewaySize = gatewaySizeValue;
    }
    
    private long instanceCount;
    
    /**
    * Optional. The number of instances of this gateway.
    * @return The InstanceCount value.
    */
    public long getInstanceCount() {
        return this.instanceCount;
    }
    
    /**
    * Optional. The number of instances of this gateway.
    * @param instanceCountValue The InstanceCount value.
    */
    public void setInstanceCount(final long instanceCountValue) {
        this.instanceCount = instanceCountValue;
    }
    
    private String name;
    
    /**
    * Optional. The friendly name of the gateway
    * @return The Name value.
    */
    public String getName() {
        return this.name;
    }
    
    /**
    * Optional. The friendly name of the gateway
    * @param nameValue The Name value.
    */
    public void setName(final String nameValue) {
        this.name = nameValue;
    }
    
    private String state;
    
    /**
    * Optional. The provisioning state of the gateway.
    * @return The State value.
    */
    public String getState() {
        return this.state;
    }
    
    /**
    * Optional. The provisioning state of the gateway.
    * @param stateValue The State value.
    */
    public void setState(final String stateValue) {
        this.state = stateValue;
    }
    
    private ArrayList<String> subnets;
    
    /**
    * Optional. Subnets in the vnet to which the gateway belongs.
    * @return The Subnets value.
    */
    public ArrayList<String> getSubnets() {
        return this.subnets;
    }
    
    /**
    * Optional. Subnets in the vnet to which the gateway belongs.
    * @param subnetsValue The Subnets value.
    */
    public void setSubnets(final ArrayList<String> subnetsValue) {
        this.subnets = subnetsValue;
    }
    
    private ArrayList<String> virtualIPs;
    
    /**
    * Optional. Virtual IP list of the gateway.
    * @return The VirtualIPs value.
    */
    public ArrayList<String> getVirtualIPs() {
        return this.virtualIPs;
    }
    
    /**
    * Optional. Virtual IP list of the gateway.
    * @param virtualIPsValue The VirtualIPs value.
    */
    public void setVirtualIPs(final ArrayList<String> virtualIPsValue) {
        this.virtualIPs = virtualIPsValue;
    }
    
    private String vnetName;
    
    /**
    * Optional. The VNET to which the gateway belongs.
    * @return The VnetName value.
    */
    public String getVnetName() {
        return this.vnetName;
    }
    
    /**
    * Optional. The VNET to which the gateway belongs.
    * @param vnetNameValue The VnetName value.
    */
    public void setVnetName(final String vnetNameValue) {
        this.vnetName = vnetNameValue;
    }
    
    /**
    * Initializes a new instance of the ApplicationGatewayGetResponse class.
    *
    */
    public ApplicationGatewayGetResponse() {
        super();
        this.setSubnets(new LazyArrayList<String>());
        this.setVirtualIPs(new LazyArrayList<String>());
    }
}
