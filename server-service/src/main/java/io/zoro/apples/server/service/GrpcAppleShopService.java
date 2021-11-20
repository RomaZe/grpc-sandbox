package io.zoro.apples.server.service;

import Apple.*;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import io.zoro.apples.server.AppleShop;

public class GrpcAppleShopService extends AppleShopServiceGrpc.AppleShopServiceImplBase {
    @Override
    public void checkApple(AppleCountRequest request, StreamObserver<AppleCountResponse> responseObserver) {
        AppleCountResponse.Builder response = AppleCountResponse.newBuilder();
    }

    private int getAppleCount(AppleShop appleShop) {
        return appleShop.getApples().size();

    }

    @Override
    public void buyApple(RequestApple request, StreamObserver<ResponseApple> responseObserver) {
        super.buyApple(request, responseObserver);
    }

    @Override
    public void addApple(AppleAddCountRequest request, StreamObserver<Empty> responseObserver) {
        super.addApple(request, responseObserver);
    }
}
