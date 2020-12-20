package com.java05_collection.lesson02_collection_interface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Collection<String> names = new ArrayList<>();
        names.add("Adnin");
        names.addAll(Arrays.asList("Rifandi", "Sutanto"));
        names.addAll(List.of("Putra", "END"));

        System.out.println("----- first");
        for (var name: names) {
            System.out.println("name = " + name);
        }

        names.remove("END");

        System.out.println("----- second");
        for (var name: names) {
            System.out.println("name = " + name);
        }

        names.removeAll(List.of("Sutanto", "Putra"));

        System.out.println("----- third");
        for (var name: names) {
            System.out.println("name = " + name);
        }

        System.out.println("----- Cek element di Collection");
        System.out.println(names.contains("Adnin"));
        System.out.println(names.contains("Sutanto"));
        System.out.println(names.containsAll(List.of("Adnin", "Sutanto"))); // semua data harus ada, kalo tidak, return false

        System.out.println("----- Cek size dari Collection");
        System.out.println(names.size());
    }
}
