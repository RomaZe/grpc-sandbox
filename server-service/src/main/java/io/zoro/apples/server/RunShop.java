package io.zoro.apples.server;

import java.io.IOException;
import java.util.ArrayList;
import Apple.ColorType;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.zoro.apples.server.service.GrpcAppleShopService;

public class RunShop {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("It is a new day...");

        AppleShopInformation appleShopInformation = new AppleShopInformation();

        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple(10, ColorType.red.toString()));
        apples.add(new Apple(5, ColorType.blue.toString()));
        apples.add(new Apple(15, ColorType.green.toString()));

        AppleShop appleShop = openShop("SZAO");
        appleShop.addApple(apples);
        // Add information about AppleShop
        appleShopInformation.getAppleShopMap().put(appleShop.getName(), appleShop);

        // Open shop
        Server server = ServerBuilder.forPort(9090).addService(new GrpcAppleShopService(appleShopInformation)).build();
        server.start();
        System.out.println("Shop is ready to get client on port" + server.getPort());
        System.out.println(String.format("Shop %s is open. Amount of apples: %d", appleShop.getName(), appleShop.getApples().size()));
        server.awaitTermination();

    }

    private static AppleShop openShop(String name) {
        AppleShop appleShop = new AppleShop(name);
        System.out.println("Open a new shop: " + appleShop.getName());
        return appleShop;
    }
}
