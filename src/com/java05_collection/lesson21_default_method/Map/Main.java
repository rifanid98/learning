package com.java05_collection.lesson21_default_method.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("first", "Adnin");
        map.put("first", "Rifandi");
        map.put("first", "Sutanto");

        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(key + "\t:" + value);
            }
        });
    }
}
