// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.textanalytics.batch;

import com.azure.ai.textanalytics.TextAnalyticsAsyncClient;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.ai.textanalytics.models.TextAnalyticsApiKeyCredential;
import com.azure.ai.textanalytics.models.TextAnalyticsRequestOptions;
import com.azure.ai.textanalytics.models.TextDocumentBatchStatistics;
import com.azure.ai.textanalytics.models.TextDocumentInput;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Sample demonstrates how to asynchronously recognize the PII(Personally Identifiable Information) entities of
 * documents.
 */
public class RecognizePiiBatchDocumentsAsync {
    /**
     * Main method to invoke this demo about how to recognize the Personally Identifiable Information entities of
     * documents.
     *
     * @param args Unused arguments to the program.
     */
    public static void main(String[] args) {
        // Instantiate a client that will be used to call the service.
        TextAnalyticsAsyncClient client = new TextAnalyticsClientBuilder()
            .apiKey(new TextAnalyticsApiKeyCredential("{api_key}"))
            .endpoint("{endpoint}")
            .buildAsyncClient();

        // The texts that need be analyzed.
        List<TextDocumentInput> inputs = Arrays.asList(
            new TextDocumentInput("1", "My SSN is 555-55-5555", "en"),
            new TextDocumentInput("2", "Visa card 4111 1111 1111 1111", "en")
        );

        // Request options: show statistics and model version
        final TextAnalyticsRequestOptions requestOptions = new TextAnalyticsRequestOptions().setIncludeStatistics(true);

        // Recognizing batch entities
        client.recognizePiiEntitiesBatch(inputs, requestOptions).byPage().subscribe(
            pagedResponse -> {
                System.out.printf("Model version: %s%n", pagedResponse.getModelVersion());

                // Batch statistics
                final TextDocumentBatchStatistics batchStatistics = pagedResponse.getStatistics();
                System.out.printf("A batch of documents statistics, document count: %s, erroneous document count: %s, transaction count: %s, valid document count: %s.%n",
                    batchStatistics.getDocumentCount(), batchStatistics.getInvalidDocumentCount(), batchStatistics.getTransactionCount(), batchStatistics.getValidDocumentCount());

                // Recognized Personally Identifiable Information entities for each of documents from a batch of documents
                pagedResponse.getElements().forEach(entitiesResult -> {
                    System.out.printf("%nDocument ID: %s%n", entitiesResult.getId());
                    if (entitiesResult.isError()) {
                        // Erroneous document
                        System.out.printf("Cannot recognize Personally Identifiable Information entities. Error: %s%n", entitiesResult.getError().getMessage());
                    } else {
                        // Valid document
                        entitiesResult.getEntities().forEach(entity -> System.out.printf(
                            "Recognized personal identifiable information entity: %s, entity category: %s, entity sub-category: %s, score: %f.%n",
                            entity.getText(), entity.getCategory(), entity.getSubCategory(), entity.getConfidenceScore()));
                    }
                });
            },
            error -> System.err.printf("There was an error recognizing Personally Identifiable Information entities of the documents. %s%n", error),
            () -> System.out.println("Batch of Personally Identifiable Information entities recognized."));

        // The .subscribe() creation and assignment is not a blocking call. For the purpose of this example, we sleep
        // the thread so the program does not end before the send operation is complete. Using .block() instead of
        // .subscribe() will turn this into a synchronous call.
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ignored) {
        }
    }
}
