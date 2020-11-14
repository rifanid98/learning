package com.java03_standard_classes.lesson11_runtime_class;

public class Main {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        System.out.println(runtime.availableProcessors());
        System.out.println(runtime.freeMemory());   // in JVM
        System.out.println(runtime.totalMemory());  // in JVM
        System.out.println(runtime.maxMemory());    // in JVM
    }
}
