package com.java05_collection.lesson14_navigable_map;

import java.util.Collections;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        /**
         * Mutable NavigableMap
         */
        /* Ascending */
        NavigableMap<String, String> navigableMap1 = new TreeMap<>();
        navigableMap1.put("first", "Adnin");
        navigableMap1.put("middle", "Rifandi");
        navigableMap1.put("last", "Sutanto");

        System.out.println("----- Ascending");
        for (String key: navigableMap1.keySet()) {
            System.out.println(key + "\t:" + navigableMap1.get(key));
        }

        System.out.println(navigableMap1.lowerKey("last"));
        System.out.println(navigableMap1.higherKey("last"));
        System.out.println(navigableMap1.floorKey("nugraha"));
        System.out.println(navigableMap1.ceilingKey("nugraha"));

        /* Descending */
        NavigableMap<String, String> navigableMap2 = new TreeMap<>();
        //NavigableMap<String, String> navigableMap2 = navigableMap1.descendingMap(); // cara 1
        navigableMap2.put("first", "Adnin");
        navigableMap2.put("middle", "Rifandi");
        navigableMap2.put("last", "Sutanto");

        System.out.println("----- Descending");
        for (String key: navigableMap2.descendingKeySet()) { // cara 2 menggunakan descendingKeySet()
            System.out.println(key + "\t:" + navigableMap2.get(key));
        }

        System.out.println(navigableMap2.lowerKey("last"));
        System.out.println(navigableMap2.higherKey("last"));
        System.out.println(navigableMap2.floorKey("nugraha"));
        System.out.println(navigableMap2.ceilingKey("nugraha"));

        /**
         * Immutable NavigableMap
         */
        NavigableMap<String, String> emptyImmutableNavigableMap = Collections.emptyNavigableMap();
        NavigableMap<String, String> immutableNavigableMap = Collections.unmodifiableNavigableMap(navigableMap2);
    }
}
