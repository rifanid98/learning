package com.java05_collection.lesson17_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.addAll(List.of("Adnin", "Rifandi", "Sutanto", "Putra"));

        System.out.println("----- before sort");
        for (String value: list) {
            System.out.println(value);
        }

        Collections.sort(list);

        System.out.println("----- after sort");
        for (String value: list) {
            System.out.println(value);
        }

        Comparator<String> reverseComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1); // descending
                //return o1.compareTo(o2); // ascending
            }
        };

        Collections.sort(list, reverseComparator);

        System.out.println("----- sort + comparator");
        for (String value: list) {
            System.out.println(value);
        }

    }
}
