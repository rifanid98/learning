package com.java05_collection.lesson08_navigable_set_interface;


import java.util.Collections;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("----- Mutable NavigableSet");
        NavigableSet<String> names = new TreeSet<>();
        names.add("Adnin");
        names.add("Sutanto");
        names.addAll(Set.of("Rifandi", "Putra"));

        System.out.println("----- sorting (ascending)");
        for (var name: names) {
            System.out.println(name);
        }

        System.out.println("----- sorting (descending)");
        for (var name: names.descendingSet()) {
            System.out.println(name);
        }

        NavigableSet<String> partialNames1 = names.headSet("Rifandi", true);

        System.out.println("----- partial get (head)");
        for (var name: partialNames1) {
            System.out.println(name);
        }

        NavigableSet<String> partialNames2 = names.tailSet("Rifandi", true);

        System.out.println("----- partial get (tail)");
        for (var name: partialNames2) {
            System.out.println(name);
        }

        /** Immutable Set Method */
        System.out.println("\n----- Immutable NavigableSet");
        NavigableSet<String> emptyImmutableNavigableSet = Collections.emptyNavigableSet();
        NavigableSet<String> mutableNavigableSet = new TreeSet<>();
        mutableNavigableSet.add("Adnin");
        mutableNavigableSet.add("Rifandi");
        NavigableSet<String> immutableNavigableSet = Collections.unmodifiableNavigableSet(mutableNavigableSet);
        System.out.println(immutableNavigableSet);
    }
}
