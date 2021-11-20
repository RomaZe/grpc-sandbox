package io.zoro.apples.server;

import java.util.ArrayList;
import Apple.ColorType;

public class RunShop {
    public static void main(String[] args) {
        System.out.println("It is a new day...");

        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(new Apple(10, ColorType.red.toString()));
        apples.add(new Apple(5, ColorType.blue.toString()));
        apples.add(new Apple(15, ColorType.green.toString()));

        AppleShop appleShop = new AppleShop("SZAO");
        System.out.println("Open a new shop: " + appleShop.getName());
        appleShop.addApple(apples);

        System.out.println("Start sale. Amount of apples: " + appleShop.getApples().size());

    }
}
