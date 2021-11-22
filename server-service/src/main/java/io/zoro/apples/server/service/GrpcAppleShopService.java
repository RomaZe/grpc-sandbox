package io.zoro.apples.server.service;

import Apple.*;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import io.zoro.apples.server.AppleShop;
import io.zoro.apples.server.AppleShopInformation;
import io.zoro.apples.server.RunShop;

import java.util.Map;

public class GrpcAppleShopService extends AppleShopServiceGrpc.AppleShopServiceImplBase {

    Map<String, AppleShop> appleShops;

    public GrpcAppleShopService(AppleShopInformation appleShopInformation) {
        this.appleShops = appleShopInformation.getAppleShopMap();
    }

    @Override
    public void checkApple(AppleCountRequest request, StreamObserver<AppleCountResponse> responseObserver) {
        AppleCountResponse.Builder response = AppleCountResponse.newBuilder();
        response.setCount(getAppleCount(request.getShopName()));

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();

    }

    private int getAppleCount(String appleShopName) {
            if (appleShops.containsKey(appleShopName)) {
                return appleShops.get(appleShopName).getApples().size();
            }

        return 0;
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
