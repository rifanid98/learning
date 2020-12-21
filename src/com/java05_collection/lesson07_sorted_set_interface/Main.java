package com.java05_collection.lesson07_sorted_set_interface;


import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("----- Mutable SortedSet");
        SortedSet<Person> people = new TreeSet<>(new PersonComparator()); // ascending
        //SortedSet<Person> people = new TreeSet<>(new PersonComparator().reversed()); // descending
        people.add(new Person("Adnin"));
        people.add(new Person("Sutanto"));
        people.add(new Person("Rifandi"));

        for (var person: people) {
            System.out.println(person.getName());
        }

        /** Immutable Set Method */
        System.out.println("----- Immutable SortedSet");
        SortedSet<String> emptyImmutableSortedSet = Collections.emptySortedSet();
        SortedSet<String> mutableSortedSet = new TreeSet<>();
        mutableSortedSet.add("Adnin");
        mutableSortedSet.add("Rifandi");
        SortedSet<String> immutableSortedSet = Collections.unmodifiableSortedSet(mutableSortedSet);
        System.out.println(immutableSortedSet);
    }
}
