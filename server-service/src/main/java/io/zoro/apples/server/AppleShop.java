package io.zoro.apples.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AppleShop {

    private String name;
    private List<Apple> apples = new ArrayList<>();

    public AppleShop(String name) {
        this.name = name;
    }

    public void addApple(ArrayList<Apple> apples) {
        this.apples.addAll(apples);
        System.out.println("Apple was added to the shop " + name);
    }

    public String getName() {
        return name;
    }

    public List<Apple> getApples() {
        return apples;
    }
}


