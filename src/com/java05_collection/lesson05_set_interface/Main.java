package com.java05_collection.lesson05_set_interface;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        /**
         * HashSet
         *
         * Hanya menerima satu data, tidak dapat menambahkan
         * data yang sama lebih dari satu kali.
         *
         * Pada HashSet tidak ada jaminan bahwa data akan urut.
         * */
        Set<String> names1 = new HashSet<>();
        names1.add("Adnin");
        names1.add("Rifandi");
        names1.add("Sutanto");
        names1.add("Adnin");
        names1.add("Rifandi");
        names1.add("Sutanto");

        System.out.println("----- HashSet");
        for (var name: names1) {
            System.out.println(name);
        }

        /**
         * LinkedHashSet
         *
         * Hanya menerima satu data, tidak dapat menambahkan
         * data yang sama lebih dari satu kali.
         *
         * Pada LinkedHashSet dijamin keurutan datanya.
         * */
        Set<String> names2 = new LinkedHashSet<>();
        names2.add("Adnin");
        names2.add("Rifandi");
        names2.add("Sutanto");
        names2.add("Adnin");
        names2.add("Rifandi");
        names2.add("Sutanto");

        System.out.println("----- LinkedHashSet");
        for (var name: names2) {
            System.out.println(name);
        }

        /**
         * EnumSet
         *
         *
         */
        EnumSet<Gender> genders = EnumSet.allOf(Gender.class); // cara 1
//        EnumSet<Gender> genders = EnumSet.of(Gender.MALE, Gender.FEMALE); // cara 2

        System.out.println("----- EnumSet");
        for (var gender: genders) {
            System.out.println(gender);
        }
    }

    public static enum Gender {
        MALE,
        FEMALE
    }
}
