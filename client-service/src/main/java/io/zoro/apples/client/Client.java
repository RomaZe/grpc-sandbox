package io.zoro.apples.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import Apple.*;

public class Client {
    public static void main(String[] args) {

        System.out.println("Client is starting...");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("192.168.1.101", 9090).usePlaintext().build();

        AppleShopServiceGrpc.AppleShopServiceBlockingStub shopServiceStub = AppleShopServiceGrpc.newBlockingStub(channel);
        AppleCountRequest request = AppleCountRequest.newBuilder().setShopName("SZAO").build();
        AppleCountResponse response = shopServiceStub.checkApple(request);

        System.out.println(String.format("Shop: %s; Amount of apples: %d", request.getShopName(), response.getCount()));
    }
}
