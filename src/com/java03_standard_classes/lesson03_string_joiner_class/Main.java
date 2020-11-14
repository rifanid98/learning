package com.java03_standard_classes.lesson03_string_joiner_class;

import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) {
        String[] names = {"Adnin", "Rifandi", "Sutanto", "Putra"};
        StringJoiner namesJoin = new StringJoiner("|", "<", ">");

        for (var name: names) {
            namesJoin.add(name);
        }

        System.out.println(namesJoin.toString());
    }
}
