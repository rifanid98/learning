package com.java05_collection.lesson16_legacy_collection.stack_class;

import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Adnin");
        stack.push("Rifandi");
        stack.push("Sutanto");

        for (String value = stack.pop(); value != null; value = stack.pop() ) {
            System.out.println(value);
        }
    }
}
