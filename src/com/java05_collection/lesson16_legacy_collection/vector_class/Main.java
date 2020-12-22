package com.java05_collection.lesson16_legacy_collection.vector_class;

import java.util.List;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        List<String> vector = new Vector<>();
        vector.add("Adnin");
        vector.add("Rifandi");
        vector.add("Sutanto");

        for (String key: vector) {
            System.out.println(key);
        }
    }
}
