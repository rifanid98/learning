package com.java03_standard_classes.lesson10_system_class;

public class Main {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());
        System.out.println(System.getenv("HOME"));


        System.exit(0);
        System.out.println("Teks ini tidak akan diprint");
    }
}
