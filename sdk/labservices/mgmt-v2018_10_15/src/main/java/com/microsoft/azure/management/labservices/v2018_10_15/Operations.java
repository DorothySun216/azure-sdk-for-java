/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.labservices.v2018_10_15;

import rx.Observable;
import com.microsoft.azure.management.labservices.v2018_10_15.implementation.OperationsInner;
import com.microsoft.azure.arm.model.HasInner;

/**
 * Type representing Operations.
 */
public interface Operations extends HasInner<OperationsInner> {
    /**
     * Get operation.
     *
     * @param locationName The name of the location.
     * @param operationName The name of the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable for the request
     */
    Observable<OperationResult> getAsync(String locationName, String operationName);

}
