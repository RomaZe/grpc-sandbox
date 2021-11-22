package io.zoro.apples.server;

import java.util.HashMap;
import java.util.Map;

public class AppleShopInformation {
    Map<String, AppleShop> appleShopMap;

    public AppleShopInformation() {
        appleShopMap = new HashMap<>();
    }

    public Map<String, AppleShop> getAppleShopMap() {
        return appleShopMap;
    }

    public void setAppleShopMap(Map<String, AppleShop> appleShopMap) {
        this.appleShopMap = appleShopMap;
    }
}
