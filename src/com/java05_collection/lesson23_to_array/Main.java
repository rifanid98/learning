package com.java05_collection.lesson23_to_array;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of("Adnin", "Rifandi", "Sutanto", "Putra");
        Object[] objects = names.toArray();
        String[] strings = names.toArray(new String[]{});

        System.out.println(Arrays.toString(objects));
        System.out.println(Arrays.toString(strings));
    }
}
