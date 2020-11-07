package com.java01_fundamental.lesson04_casting_numeric_data_type;

public class Main {

    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        int c = a / b;
        float d = (float) 10 / b;
        System.out.println("Without casting " + c); // 3
        System.out.println("With casting " + d);    // 3.333...
    }
}
