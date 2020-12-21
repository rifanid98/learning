package com.java05_collection.lesson12_immutable_map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /** EmptyMap */
        System.out.println("----- emptyMap()");
        Map<String, String> emptyMap = Collections.emptyMap();
        System.out.println(emptyMap);

        /** SingletonMap */
        System.out.println("----- singletonMap()");
        Map<String, String> singletonMap = Collections.singletonMap("name", "adnin");
        System.out.println(singletonMap);

        /** Immutable Map */
        // cara 1
        Map<String, String> mutableMap = new HashMap<>();
        mutableMap.put("name", "Adnin Rifandi");
        mutableMap.put("address", "kp. sinagar");
        Map<String, String> immutableMap1 = Collections.unmodifiableMap(mutableMap);
        //immutableMap1.put("lastest", "Putra"); // error, immutable!

        System.out.println("----- unmodifiableMap()");
        System.out.println(immutableMap1);

        // cara 2
        Map<String, String> immutableMap2 = Map.of(
                "first", "Adnin",
                "middle", "Rifandi",
                "last", "Sutanto"
        );
        //immutableMap2.put("lastest", "Putra"); // error, immutable!

        System.out.println("----- Map.of(...)");
        System.out.println(immutableMap2);
    }
}
