package com.java03_standard_classes.lesson13_base64_class;

import java.util.Base64;

/**
 * Base64
 */
public class Main {

    public static void main(String[] args) {
        String string = "Adnin Rifandi Sutanto Putra";
        System.out.println("String awal\t\t: " + string);

        /** Encoding */
        byte[] stringBytes = string.getBytes();
        System.out.println("String bytes\t: " + stringBytes);
        String encode = Base64.getEncoder().encodeToString(stringBytes);
        System.out.println("String encode\t: " + encode);

        /** Decoding */
        stringBytes = Base64.getDecoder().decode(encode);
        System.out.println("String bytes\t: " + stringBytes);
        String decode = new String(stringBytes);
        System.out.println("String decode\t: " + decode);
    }
}
