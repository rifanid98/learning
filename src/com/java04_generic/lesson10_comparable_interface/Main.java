package com.java04_generic.lesson10_comparable_interface;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Person[] person = {
            new Person("Sutanto", "Sinagar"),
            new Person("Adnin", "Pasar Rebo"),
            new Person("Rifandi", "Ciampea")
        };

        Arrays.sort(person);
        System.out.println(Arrays.toString(person));
    }
}
