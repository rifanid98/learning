package com.java05_collection.lesson04_immutable_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /** Mutable List Problem */
        Person person =  new Person("Adnin");
        person.addHobby("Badminton");
        person.addHobby("Coding");

        /**
         * ketika hobbies ditambahkan di dalam method ini, maka
         * datanya akan berubah. berakibat pada kesalahan logic
         * di kemudian hari. karena seharusnya ketika ingin me-
         * nambahkan data ke hobbies harus melalui person.addHobby()
         * */
        doSomethingWithHobbies(person.getMutableHobbies());

        for (var hobby: person.getMutableHobbies()) {
            System.out.println(hobby);
        }

        /** Immutable List datanya tidak bisa dimodifikasi */
//        doSomethingWithHobbies(person.getImmutableHobbies()); // akan error, karena sudah immutable

        /** Immutable List Method */
        List<String> emptyImmutableList = Collections.emptyList();
        List<String> oneImmutableList = Collections.singletonList("Adnin");
        List<String> mutableList = new ArrayList<>();
        mutableList.add("Adnin");
        mutableList.add("Rifandi");
        List<String> immutableList1 = Collections.unmodifiableList(mutableList);
        List<String> immutableList2 = Collections.unmodifiableList(List.of("Adnin", "Rifandi"));
        List<String> immutableList3 = List.of("Adnin", "Rifandi");
    }

    public static void doSomethingWithHobbies(List<String> hobbies) {
        hobbies.add("Unknown");
    }
}
