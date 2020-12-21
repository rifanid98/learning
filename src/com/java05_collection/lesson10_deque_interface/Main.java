package com.java05_collection.lesson10_deque_interface;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        /**
         * pollLast() untuk mengambil data
         * dari paling terakhir
         */
        Deque<String> deque1 = new LinkedList<>();
        deque1.offerLast("Adnin");
        deque1.offerLast("Rifandi");
        deque1.offerLast("Sutanto");

        System.out.println("----- pollLast()");
        for (String stack = deque1.pollLast(); stack != null; stack = deque1.pollLast()) {
            System.out.println(stack);
        }

        /**
         * pollFirst() untuk mengambil data
         * dari paling awal karena antrian
         * itu pasti yang paling pertamalah
         * yang dipanggil lebih dulu
         */
        Deque<String> deque2 = new LinkedList<>();
        deque2.offerLast("Adnin");
        deque2.offerLast("Rifandi");
        deque2.offerLast("Sutanto");

        System.out.println("----- pollFirst()");
        for (String stack = deque2.pollFirst(); stack != null; stack = deque2.pollFirst()) {
            System.out.println(stack);
        }
    }
}
