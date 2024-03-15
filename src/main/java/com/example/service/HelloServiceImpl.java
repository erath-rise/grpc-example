package com.example.service;

import com.example.HelloProto;
import com.example.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(HelloProto.HelloRequest request, StreamObserver<HelloProto.HelloResponse> responseObserver) {
        String greeting = "Hello," + request.getName() + "!";

        HelloProto.HelloResponse reply = HelloProto.HelloResponse.newBuilder().setMessage(greeting).build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
