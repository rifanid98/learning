package com.java05_collection.lesson20_abstract_collection;

import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> queue = new SingleQueue<>();
        System.out.println(queue.offer("Adnin"));
        System.out.println(queue.offer("Rifandi"));
        System.out.println(queue.offer("Sutanto"));
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.size());
    }
}
