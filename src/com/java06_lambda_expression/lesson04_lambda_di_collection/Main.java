package com.java06_lambda_expression.lesson04_lambda_di_collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        /**
         * iterable.forEach()
         */
        List<String> names1 = List.of("Adnin", "Rifandi", "Sutanto", "Putra");

        /* With For loop */
        for (String name: names1) {
            System.out.println(name);
        }
        /* With Anonymous Class */
        names1.forEach(new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println(name);
            }
        });
        /* With Lambda Expression */
        names1.forEach(name -> System.out.println(name));
        /* With Lambda Expression Method Reference */
        names1.forEach(System.out::println);

        /**
         * Collection.removeIf()
         */
        List<String> names2 = new ArrayList<>();
        names2.addAll(List.of("Adnin", "Rifandi", "Sutanto", "Putra"));

        /* With Anonymous Class */
        names2.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String name) {
                return name.length() > 5;
            }
        });
        /* With Lambda Expression */
        names2.removeIf(name -> name.length() > 5);

        /**
         * Map.forEach()
         */
        Map<String, String> map = new HashMap<>();
        map.put("first", "Adnin");
        map.put("middle", "Rifandi");
        map.put("last", "Sutanto");

        /* With For Loop */
        for (var key: map.entrySet()) {
            System.out.println(key + "\t:" + map.get(key));
        }
        /* With Anonymous Class */
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(key + "\t:" + value);
            }
        });
        /* With Lambda Expression */
        map.forEach((key, value) -> System.out.println(key + "\t:" + value));
    }
}
