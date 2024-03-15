package com.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import com.example.service.HelloServiceImpl;

import java.io.IOException;

public class HelloWorldServer {
    public static void main(String[] args) {
        try {
            ServerBuilder serverBuilder = ServerBuilder.forPort(9000);
            serverBuilder.addService(new HelloServiceImpl());

            Server server = serverBuilder.build();
            server.start();
            System.out.println("Server started on port 9000");

            server.awaitTermination();
    } catch (IOException | InterruptedException e) {
        e.printStackTrace();
    }
    }
}
