package com.java04_generic.lesson11_comparator_interface;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Person[] person = {
            new Person("Sutanto", "Sinagar"),
            new Person("Adnin", "Pasar Rebo"),
            new Person("Rifandi", "Ciampea")
        };

        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAddress().compareTo(o2.getAddress());
            }
        };

        Arrays.sort(person, comparator);
        System.out.println(Arrays.toString(person));
    }
}
