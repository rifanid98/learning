package com.java05_collection.lesson15_entry_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("first", "Adnin");
        map.put("middle", "Rifandi");
        map.put("last", "Sutanto");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry entry: entries) {
            System.out.println(entry.getKey() + "\t:" + entry.getValue());
        }
    }
}
