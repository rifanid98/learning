package com.fundamental;

public class OperatorCasting {

    public static void main(String[] args) {
        int a = 10;
        int b = 3;
        int c = a / b;
        float d = (float) 10 / b;
        System.out.println("Without casting " + c); // 3
        System.out.println("With casting " + d);    // 3.333...
    }
}
