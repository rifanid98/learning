package com.java03_standard_classes.lesson07_big_number;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        BigInteger a = new BigInteger("1000000000000000000");
        BigInteger b = new BigInteger("1000000000000000000");
        BigInteger c = a.add(b);        // +
        BigInteger d = a.subtract(b);   // -
        BigInteger e = a.multiply(b);   // *
        BigInteger f = a.divide(b);     // /
        BigInteger g = a.mod(b);        // %

        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
    }
}
