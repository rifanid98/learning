package com.java05_collection.lesson18_binary_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(1000);
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        System.out.println("----- binarySearch1");
        int index = Collections.binarySearch(list, 333);
        System.out.println(index);

        System.out.println("----- binarySearch2 with comparator");
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };

        int index2 = Collections.binarySearch(list, 333);
        System.out.println(index2);
    }
}
