package com.java05_collection.lesson13_sorted_map;

import java.util.Collections;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        /**
         * Mutable SortedMap
         */

        /** with comparable */
        SortedMap<String, String> sortedMap1 = new TreeMap<>();
        sortedMap1.put("first", "Adnin");
        sortedMap1.put("middle", "Rifandi");
        sortedMap1.put("last", "Sutanto");

        /** for loop */
        System.out.println("----- with comparable");
        for (String key: sortedMap1.keySet()) {
            System.out.println(key + "\t:" + sortedMap1.get(key));
        }

        /** with comparator */
        Comparator<String> sortedMapComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };

        SortedMap<String, String> sortedMap2 = new TreeMap<>(sortedMapComparator);
        sortedMap2.put("first", "Adnin");
        sortedMap2.put("middle", "Rifandi");
        sortedMap2.put("last", "Sutanto");

        /** for loop */
        System.out.println("----- with comparator");
        for (String key: sortedMap2.keySet()) {
            //System.out.println(key);
            System.out.println(key + "\t:" + sortedMap2.get(key));
        }

        /** Immutable SortedMap */
        SortedMap<String, String> emptySortedMap = Collections.emptySortedMap();
        SortedMap<String, String> immutableMap = Collections.unmodifiableSortedMap(sortedMap2);
    }
}
