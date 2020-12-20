package com.java05_collection.lesson06_immutable_set;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        /** Immutable Set Method */
        Set<String> emptyImmutableSet = Collections.emptySet();
        Set<String> oneImmutableSet = Collections.singleton("Adnin");
        Set<String> mutableSet = new HashSet<>();
        mutableSet.add("Adnin");
        mutableSet.add("Rifandi");
        Set<String> immutableSet1 = Collections.unmodifiableSet(mutableSet);
        Set<String> immutableSet2 = Collections.unmodifiableSet(Set.of("Adnin", "Rifandi"));
        Set<String> immutableSet3 = Set.of("Adnin", "Rifandi");
    }

    public static void doSomethingWithHobbies(Set<String> hobbies) {
        hobbies.add("Unknown");
    }
}
