package com.java05_collection.lesson10_deque_interface;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();
        deque.offerLast("Adnin");
        deque.offerLast("Rifandi");
        deque.offerLast("Sutanto");

        for (var value: deque) {
            System.out.println(value);
        }
    }
}
