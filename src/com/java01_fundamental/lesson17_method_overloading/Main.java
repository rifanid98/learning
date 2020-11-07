package com.java01_fundamental.lesson17_method_overloading;

public class Main {

    public static void main(String[] args) {
        overloadMethod(1);
        overloadMethod(1.0);
        overloadMethod(2.2);
        overloadMethod(111);
    }

    /**
     * Ketika ingin menggunakan method yang sama namun
     * dengan parameter yang berbeda bisa menggunakan
     * overload function/method
     */
    public static void overloadMethod(int number) {
        System.out.println("Inpur parametenya adalah " + number);
    }
    public static void overloadMethod(float number) {
        System.out.println("Inpur parametenya adalah " + number);
    }
    public static void overloadMethod(double number) {
        System.out.println("Inpur parametenya adalah " + number);
    }
    public static void overloadMethod(long number) {
        System.out.println("Inpur parametenya adalah " + number);
    }
}
