package com.java05_collection.lesson11_map_interface;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /** HashMap */
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("name", "Adnin Rifandi");
        hashMap.put("address", "kp. sinagar");

        System.out.println("----- HashMap");
        System.out.println(hashMap.get("name"));
        System.out.println(hashMap.get("address"));

        /** WeakHashMap */
        Map<Integer, Integer> weakHashMap = new WeakHashMap<>();
        for (int i = 0; i < 1_000_000; i++) {
            weakHashMap.put(i, i);
        }

        System.out.println("----- WeakHashMap");
        System.out.println("before gc()");
        System.out.println(weakHashMap.size());
        System.gc();
        System.out.println("after gc()");
        System.out.println(weakHashMap.size());

        /** IdentityHashMap */
        // berada di lokasi 1
        String key1 = "name.first";

        // berada di lokasi 2
        String first = "first";
        String key2 = "name." + first;

        // berada di lokasi 1 (karena value stringnya sama)
        String key3 = "name.first";

        System.out.println("----- IdentityHashMap");
        Map<String, String> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(key1, "Adnin");
        identityHashMap.put(key2, "Adnin");
        identityHashMap.put(key3, "Adnin"); // tidak akan dimasukkan, karena memiliki
                                            // lokasi yang sama dengan key1

        System.out.println(identityHashMap.size());
        System.out.println(identityHashMap.get("name.first"));

        /** LinkedHashMap */
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("first", "Adnin");
        linkedHashMap.put("middle", "Rifandi");
        linkedHashMap.put("last", "Sutanto");

        System.out.println("----- LinkedHashMap");
        for (var key: linkedHashMap.keySet()) {
            System.out.println(key);
        }

        /** EnumMap */
        EnumMap<Level, String> enumMap = new EnumMap<Level, String>(Level.class);
        enumMap.put(Level.EASY, "Easy Mode");
        enumMap.put(Level.MEDIUM, "Medium Mode");
        enumMap.put(Level.HARD, "Hard Mode");

        System.out.println("----- EnumMap");
        for (Level key: enumMap.keySet()) {
            System.out.println(key + "\t:" + enumMap.get(key));
        }
    }

    public static enum Level {EASY,MEDIUM,HARD}
}
