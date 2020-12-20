package com.java05_collection.lesson01_iterable_and_iterator_interface;

import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Iterable<String> names = List.of("Adnin", "Rifandi", "Sutanto", "Putra");

        /** using foreach */
        for (var name: names) {
            System.out.println("foreach = " + name);
        }

        /** using iterator */
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println("iterator = " + name);
        }
    }
}
