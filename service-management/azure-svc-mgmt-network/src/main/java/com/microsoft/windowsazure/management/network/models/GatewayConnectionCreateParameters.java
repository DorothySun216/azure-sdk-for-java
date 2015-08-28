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

/**
* Parameters supplied to the Create Virtual Network Gateway Connection
* operation.
*/
public class GatewayConnectionCreateParameters {
    private String connectedEntityId;
    
    /**
    * Optional. The Service Key / Local network gateway Id / Vnet Network
    * Gateway Id.
    * @return The ConnectedEntityId value.
    */
    public String getConnectedEntityId() {
        return this.connectedEntityId;
    }
    
    /**
    * Optional. The Service Key / Local network gateway Id / Vnet Network
    * Gateway Id.
    * @param connectedEntityIdValue The ConnectedEntityId value.
    */
    public void setConnectedEntityId(final String connectedEntityIdValue) {
        this.connectedEntityId = connectedEntityIdValue;
    }
    
    private String gatewayConnectionName;
    
    /**
    * Optional. The name of the virtual network gateway connection.
    * @return The GatewayConnectionName value.
    */
    public String getGatewayConnectionName() {
        return this.gatewayConnectionName;
    }
    
    /**
    * Optional. The name of the virtual network gateway connection.
    * @param gatewayConnectionNameValue The GatewayConnectionName value.
    */
    public void setGatewayConnectionName(final String gatewayConnectionNameValue) {
        this.gatewayConnectionName = gatewayConnectionNameValue;
    }
    
    private String gatewayConnectionType;
    
    /**
    * Optional. The connection type of gateway:
    * Ipsec/Dedicated/VpnClient/Vnet2Vnet.
    * @return The GatewayConnectionType value.
    */
    public String getGatewayConnectionType() {
        return this.gatewayConnectionType;
    }
    
    /**
    * Optional. The connection type of gateway:
    * Ipsec/Dedicated/VpnClient/Vnet2Vnet.
    * @param gatewayConnectionTypeValue The GatewayConnectionType value.
    */
    public void setGatewayConnectionType(final String gatewayConnectionTypeValue) {
        this.gatewayConnectionType = gatewayConnectionTypeValue;
    }
    
    private int routingWeight;
    
    /**
    * Optional. The Routing Weight.
    * @return The RoutingWeight value.
    */
    public int getRoutingWeight() {
        return this.routingWeight;
    }
    
    /**
    * Optional. The Routing Weight.
    * @param routingWeightValue The RoutingWeight value.
    */
    public void setRoutingWeight(final int routingWeightValue) {
        this.routingWeight = routingWeightValue;
    }
    
    private String sharedKey;
    
    /**
    * Optional. The Ipsec share key.
    * @return The SharedKey value.
    */
    public String getSharedKey() {
        return this.sharedKey;
    }
    
    /**
    * Optional. The Ipsec share key.
    * @param sharedKeyValue The SharedKey value.
    */
    public void setSharedKey(final String sharedKeyValue) {
        this.sharedKey = sharedKeyValue;
    }
    
    private String virtualNetworkGatewayId;
    
    /**
    * Optional. The Virtual network gateway Id.
    * @return The VirtualNetworkGatewayId value.
    */
    public String getVirtualNetworkGatewayId() {
        return this.virtualNetworkGatewayId;
    }
    
    /**
    * Optional. The Virtual network gateway Id.
    * @param virtualNetworkGatewayIdValue The VirtualNetworkGatewayId value.
    */
    public void setVirtualNetworkGatewayId(final String virtualNetworkGatewayIdValue) {
        this.virtualNetworkGatewayId = virtualNetworkGatewayIdValue;
    }
}
