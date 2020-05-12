package com.microsoft.azure.servicebus;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.microsoft.azure.servicebus.management.ManagementClient;
import com.microsoft.azure.servicebus.management.ManagementClientAsync;
import com.microsoft.azure.servicebus.management.QueueDescription;
import com.microsoft.azure.servicebus.primitives.ConnectionStringBuilder;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;
import com.microsoft.azure.servicebus.primitives.TransportType;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.asynchttpclient.DefaultAsyncHttpClientConfig;
import org.asynchttpclient.Realm;
import org.asynchttpclient.proxy.ProxyServer;
import org.asynchttpclient.proxy.ProxyType;
import org.junit.Assert;
import org.junit.Test;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.net.*;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.nio.charset.StandardCharsets.UTF_8;

public class DaxiTest {
    static final Gson GSON = new Gson();

    @Test
    public void queueClientWithProxy() throws Exception {
        String proxyHostName = "127.0.0.1";
        int proxyPort = 8888;
        final ProxySelector systemDefaultSelector = ProxySelector.getDefault();
        ProxySelector.setDefault(new ProxySelector() {
            @Override
            public List<Proxy> select(URI uri) {
                if (uri != null
                    && uri.getHost() != null
//                    && uri.getHost().equalsIgnoreCase(proxyHostName)
                    ) {
                    List<Proxy> proxies = new LinkedList<>();
                    proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHostName, proxyPort)));
                    return proxies;
                }
                return systemDefaultSelector.select(uri);
            }

            @Override
            public void connectFailed(URI uri, SocketAddress sa, IOException ioe){
                if (uri == null || sa == null || ioe == null) {
                    throw new IllegalArgumentException("Arguments can't be null.");
                }
                systemDefaultSelector.connectFailed(uri, sa, ioe);
            }
        });

        String connectionString = "Endpoint=sb://anqyan-messaging.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=gqHB0C/IfW/d8uECt5OgHJSAnV7TEDYw2ps6gNURHK0=";
        ConnectionStringBuilder connStrBuilder = new ConnectionStringBuilder(connectionString, "javaqueue");
        connStrBuilder.setTransportType(TransportType.AMQP_WEB_SOCKETS);

        QueueClient receiveClient = new QueueClient(connStrBuilder, ReceiveMode.PEEKLOCK);
        // We are using single thread executor as we are only processing one message at a time
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        this.registerReceiver(receiveClient, executorService);

        // Create a QueueClient instance for sending and then asynchronously send messages.
        // Close the sender once the send operation is complete.
        QueueClient sendClient = new QueueClient(connStrBuilder, ReceiveMode.PEEKLOCK);
        this.sendMessagesAsync(sendClient).thenRunAsync(() -> sendClient.closeAsync());

        // wait for ENTER or 10 seconds elapsing
        waitForEnter(10);

        // shut down receiver to close the receive loop
        receiveClient.close();
        executorService.shutdown();
    }

    CompletableFuture<Void> sendMessagesAsync(QueueClient sendClient) {
        List<HashMap<String, String>> data =
            GSON.fromJson(
                "[" +
                    "{'name' = 'Einstein', 'firstName' = 'Albert'}," +
                    "{'name' = 'Heisenberg', 'firstName' = 'Werner'}," +
                    "{'name' = 'Curie', 'firstName' = 'Marie'}," +
                    "{'name' = 'Hawking', 'firstName' = 'Steven'}," +
                    "{'name' = 'Newton', 'firstName' = 'Isaac'}," +
                    "{'name' = 'Bohr', 'firstName' = 'Niels'}," +
                    "{'name' = 'Faraday', 'firstName' = 'Michael'}," +
                    "{'name' = 'Galilei', 'firstName' = 'Galileo'}," +
                    "{'name' = 'Kepler', 'firstName' = 'Johannes'}," +
                    "{'name' = 'Kopernikus', 'firstName' = 'Nikolaus'}" +
                    "]",
                new TypeToken<List<HashMap<String, String>>>() {}.getType());

        List<CompletableFuture> tasks = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            final String messageId = Integer.toString(i);
            Message message = new Message(GSON.toJson(data.get(i), Map.class).getBytes(UTF_8));
            message.setContentType("application/json");
            message.setLabel("Scientist");
            message.setMessageId(messageId);
            message.setTimeToLive(Duration.ofMinutes(2));
            System.out.printf("\nMessage sending: Id = %s", message.getMessageId());
            tasks.add(
                sendClient.sendAsync(message).thenRunAsync(() -> {
                    System.out.printf("\n\tMessage acknowledged: Id = %s", message.getMessageId());
                }));
        }
        return CompletableFuture.allOf(tasks.toArray(new CompletableFuture<?>[tasks.size()]));
    }

    void registerReceiver(QueueClient queueClient, ExecutorService executorService) throws Exception {


        // register the RegisterMessageHandler callback with executor service
        queueClient.registerMessageHandler(new IMessageHandler() {
                                               // callback invoked when the message handler loop has obtained a message
                                               public CompletableFuture<Void> onMessageAsync(IMessage message) {
                                                   // receives message is passed to callback
                                                   if (message.getLabel() != null &&
                                                       message.getContentType() != null &&
                                                       message.getLabel().contentEquals("Scientist") &&
                                                       message.getContentType().contentEquals("application/json")) {

                                                       byte[] body = message.getBody();
                                                       Map scientist = GSON.fromJson(new String(body, UTF_8), Map.class);

                                                       System.out.printf(
                                                           "\n\t\t\t\tMessage received: \n\t\t\t\t\t\tMessageId = %s, \n\t\t\t\t\t\tSequenceNumber = %s, \n\t\t\t\t\t\tEnqueuedTimeUtc = %s," +
                                                               "\n\t\t\t\t\t\tExpiresAtUtc = %s, \n\t\t\t\t\t\tContentType = \"%s\",  \n\t\t\t\t\t\tContent: [ firstName = %s, name = %s ]\n",
                                                           message.getMessageId(),
                                                           message.getSequenceNumber(),
                                                           message.getEnqueuedTimeUtc(),
                                                           message.getExpiresAtUtc(),
                                                           message.getContentType(),
                                                           scientist != null ? scientist.get("firstName") : "",
                                                           scientist != null ? scientist.get("name") : "");
                                                   }
                                                   return CompletableFuture.completedFuture(null);
                                               }

                                               // callback invoked when the message handler has an exception to report
                                               public void notifyException(Throwable throwable, ExceptionPhase exceptionPhase) {
                                                   System.out.printf(exceptionPhase + "-" + throwable.getMessage());
                                               }
                                           },
            // 1 concurrent call, messages are auto-completed, auto-renew duration
            new MessageHandlerOptions(1, true, Duration.ofMinutes(1)),
            executorService);

    }

    private void waitForEnter(int seconds) {
        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            executor.invokeAny(Arrays.asList(() -> {
                System.in.read();
                return 0;
            }, () -> {
                Thread.sleep(seconds * 1000);
                return 0;
            }));
        } catch (Exception e) {
            // absorb
        }
    }

    @Test
    public void managementClientAsync() throws InterruptedException, ExecutionException, ServiceBusException {
        URI namespaceEndpointURI = TestUtils.getNamespaceEndpointURI();
        //System.out.println("hello" + namespaceEndpointURI.getPath());
        ClientSettings managementClientSettings = TestUtils.getManagementClientSettings();
        ManagementClientAsync managementClientAsync = new ManagementClientAsync(namespaceEndpointURI, managementClientSettings);
        //ManagementClient managementClient = new ManagementClient("Endpoint=sb://contoso.servicebus.onebox.windows-int.net/;SharedAccessKeyName=DefaultNamespaceSasAllKeyName;SharedAccessKey=8864/auVd3qDC75iTjBL1GJ4D2oXC6bIttRd0jzDZ+g=");
        String queueName = "managementClientAsync" + UUID.randomUUID().toString().substring(0, 8);
        QueueDescription q = new QueueDescription(queueName);
        QueueDescription qCreated = managementClientAsync.createQueueAsync(q).get();
        Assert.assertEquals(q, qCreated);
    }


    @Test
    public void managementClientWithProxy() throws InterruptedException, ExecutionException, ServiceBusException {
        String proxyHostName = "127.0.0.1";
        int proxyPort = 8888;
        final ProxySelector systemDefaultSelector = ProxySelector.getDefault();
        ProxySelector.setDefault(new ProxySelector() {
            @Override
            public List<Proxy> select(URI uri) {
                if (uri != null
                    && uri.getHost() != null
//                    && uri.getHost().equalsIgnoreCase(proxyHostName)
                ) {
                    List<Proxy> proxies = new LinkedList<>();
                    proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHostName, proxyPort)));
                    return proxies;
                }
                return systemDefaultSelector.select(uri);
            }

            @Override
            public void connectFailed(URI uri, SocketAddress sa, IOException ioe){
                if (uri == null || sa == null || ioe == null) {
                    throw new IllegalArgumentException("Arguments can't be null.");
                }
                systemDefaultSelector.connectFailed(uri, sa, ioe);
            }
        });

        URI namespaceEndpointURI = TestUtils.getNamespaceEndpointURI();
        ClientSettings managementClientSettings = TestUtils.getManagementClientSettings();

        ManagementClient managementClient = new ManagementClient(namespaceEndpointURI, managementClientSettings);
        String queueName = "proxy" + UUID.randomUUID().toString().substring(0, 8);
        QueueDescription q = new QueueDescription(queueName);
        QueueDescription qCreated = managementClient.createQueue(q);
        Assert.assertEquals(q, qCreated);
    }

    @Test
    public void managementClient() throws InterruptedException, ExecutionException, ServiceBusException {
        URI namespaceEndpointURI = TestUtils.getNamespaceEndpointURI();
        ClientSettings managementClientSettings = TestUtils.getManagementClientSettings();
        DefaultAsyncHttpClientConfig.Builder cfg = new DefaultAsyncHttpClientConfig.Builder();
        ProxyServer.Builder proxy = new ProxyServer.Builder("127.0.0.1", 8888 );

        DefaultAsyncHttpClientConfig.Builder httpClientBuilder =
            cfg
            .setUseProxySelector(true)
            .setProxyServer(proxy);

        ManagementClient managementClient = new ManagementClient(namespaceEndpointURI, managementClientSettings, httpClientBuilder);
        String queueName = "NEW" + UUID.randomUUID().toString().substring(0, 8);
        QueueDescription q = new QueueDescription(queueName);
        QueueDescription qCreated = managementClient.createQueue(q);
        Assert.assertEquals(q, qCreated);
    }


    @Test
    public void managementClient2() throws InterruptedException, ExecutionException, ServiceBusException {
        URI namespaceEndpointURI = TestUtils.getNamespaceEndpointURI();
        //System.out.println("hello" + namespaceEndpointURI.getPath());
        ClientSettings managementClientSettings = TestUtils.getManagementClientSettings();
        //DefaultAsyncHttpClientConfig config = new DefaultAsyncHttpClientConfig.Builder().build();
        DefaultAsyncHttpClientConfig.Builder cfg = new DefaultAsyncHttpClientConfig.Builder();
        ProxyServer.Builder proxy = new ProxyServer.Builder("http://localhost", 8888 ); //"127.0.0.1"

        DefaultAsyncHttpClientConfig.Builder httpClientBuilder =
            cfg
                .setProxyServer(proxy);

        //                .setUseProxySelector(true)

//        HttpHost httpHost = new HttpHost( "127.0.0.1", 8888 );
//        RequestConfig requestConfig = RequestConfig.custom()
//            .setProxy( httpHost )
//            .build();

        //HttpClientBuilder httpClient = HttpClientBuilder.create().setProxy(httpHost);
        ManagementClient managementClient = new ManagementClient(namespaceEndpointURI, managementClientSettings, httpClientBuilder);
        //ManagementClient managementClient = new ManagementClient("Endpoint=sb://contoso.servicebus.onebox.windows-int.net/;SharedAccessKeyName=DefaultNamespaceSasAllKeyName;SharedAccessKey=8864/auVd3qDC75iTjBL1GJ4D2oXC6bIttRd0jzDZ+g=");
        String queueName = "managementClient" + UUID.randomUUID().toString().substring(0, 8);
        QueueDescription q = new QueueDescription(queueName);
        QueueDescription qCreated = managementClient.createQueue(q);
        Assert.assertEquals(q, qCreated);
    }
}
