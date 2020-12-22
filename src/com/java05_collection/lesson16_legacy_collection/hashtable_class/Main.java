package com.java05_collection.lesson16_legacy_collection.hashtable_class;

import java.util.Hashtable;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> hashtable = new Hashtable<>();
        hashtable.put("first","Adnin");
        hashtable.put("middle","Rifandi");
        hashtable.put("last","Sutanto");

        for (String key: hashtable.keySet()) {
            System.out.println(key + "\t:" + hashtable.get(key));
        }
    }
}
