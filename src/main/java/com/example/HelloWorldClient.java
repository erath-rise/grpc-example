package com.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


public class HelloWorldClient {
    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9000).usePlaintext().build();

        try {
            // Create a gRPC client stub
            HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(managedChannel);

            // Create a request
            HelloProto.HelloRequest.Builder builder = HelloProto.HelloRequest.newBuilder();
            builder.setName("peter");
            HelloProto.HelloRequest helloRequest = builder.build();

            // Call the RPC and get the response
            HelloProto.HelloResponse helloResponse = stub.hello(helloRequest);

            // Print the response
            System.out.println("Response from server: " + helloResponse.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // Shutdown the channel
            managedChannel.shutdown();
        }
    }
}
