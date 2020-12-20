package com.java05_collection.lesson09_queue_interface;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        /**
         * Array Deque
         *
         * Akan diurutkan berdasarkan posisi index
         * di mana elemen dimasukkan. misalkan value
         * "Adnin" dimasukkan atau ditambahkan di index
         * pertama, maka value "Adnin" akan menjadi
         * yang pertama
         * */
        System.out.println("---------- Queue ~ ArrayDeque ----------");
        Queue<String> queue1 = new ArrayDeque<>(4);
        queue1.offer("Adnin");
        queue1.offer("Rifandi");
        queue1.offer("Sutanto");
        queue1.offer("Putra");

        System.out.println("----- before queue1.poll()");
        System.out.println(queue1);

        /**
         * queue1.poll() akan menghapus data mengambil
         * dan menghapus data paling depan atau index
         * pertama
         */
        System.out.println("----- queue1.poll()");
        for (String next = queue1.poll(); next != null; next = queue1.poll() ) {
            System.out.println(next);
        }

        System.out.println("----- after queue1.poll()");
        System.out.println(queue1);

        /**
         * Priority Queue
         *
         * Data diurutkan berdasarkan comparable atau comparator
         * */
        System.out.println("\n---------- Queue ~ PriorityQueue ----------");
        Queue<String> queue2 = new PriorityQueue<>(4);
        queue2.offer("Adnin");
        queue2.offer("Rifandi");
        queue2.offer("Sutanto");
        queue2.offer("Putra");

        System.out.println("----- before queue2.poll()");
        System.out.println(queue2);

        /**
         * queue2.poll() akan menghapus data mengambil
         * dan menghapus data paling depan atau index
         * pertama
         */
        System.out.println("----- queue2.poll()");
        for (String next = queue2.poll(); next != null; next = queue2.poll() ) {
            System.out.println(next);
        }

        System.out.println("----- after queue2.poll()");
        System.out.println(queue2);


        /**
         * Linked List
         *
         * Data diurutkan berdasarkan comparable atau comparator
         * */
        System.out.println("\n---------- Queue ~ PriorityQueue ----------");
        Queue<String> queue3 = new LinkedList<>();
        queue3.offer("Adnin");
        queue3.offer("Rifandi");
        queue3.offer("Sutanto");
        queue3.offer("Putra");

        System.out.println("----- before queue3.poll()");
        System.out.println(queue3);

        /**
         * queue3.poll() akan menghapus data mengambil
         * dan menghapus data paling depan atau index
         * pertama
         */
        System.out.println("----- queue3.poll()");
        for (String next = queue3.poll(); next != null; next = queue3.poll() ) {
            System.out.println(next);
        }

        System.out.println("----- after queue3.poll()");
        System.out.println(queue3);
    }
}
