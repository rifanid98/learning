package com.java05_collection.lesson03_list_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(10); // array list
//        List<String> names = new LinkedList<>(10); // linked list
        names.add("Adnin");
        names.addAll(Arrays.asList("Rifandi", "Sutanto"));
        names.addAll(List.of("Putra", "END"));

        System.out.println("----- first");
        for (var name: names) {
            System.out.println("name = " + name);
        }

        names.set(4, "End");

        System.out.println("----- second");
        for (var name: names) {
            System.out.println("name = " + name);
        }

        names.remove(4); // use index
        names.remove("End"); // use value

        System.out.println("----- third");
        for (var name: names) {
            System.out.println("name = " + name);
        }
    }
}
