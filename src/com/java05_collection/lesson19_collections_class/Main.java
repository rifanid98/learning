package com.java05_collection.lesson19_collections_class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.addAll(List.of("Adnin", "Rifandi", "Sutanto", "Putra"));

        System.out.println("----- original");
        System.out.println(list);

        Collections.reverse(list);

        System.out.println("----- reversed");
        System.out.println(list);

        Collections.shuffle(list);

        System.out.println("----- shuffled");
        System.out.println(list);
    }
}
