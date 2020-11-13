package com.java02_oop.oop2_programmer_zaman_now.lesson07_equals_hashcode;

/**
 * Equals Method.
 *
 * Untuk membandingkan 2 buah objek.
 */
public class Main {
    public static void main(String[] args) {
        String name = "Adnin";
        String name2 = "Adnin";

        System.out.println(name.equals(name2)); // true
        /**
         * == hanya bisa membandingkan 2 tipe data
         * yang primitive
         */
        System.out.println(name == name2); // false

        Product product1 = new Product("Product1");
        Product product2 = new Product("Product2");
        Product product3 = new Product("Product2");
        System.out.println(product1.equals(product2)); // false
        System.out.println(product2.equals(product3)); // true
        System.out.println(product1.hashCode() == product2.hashCode()); // false
        System.out.println(product2.hashCode() == product3.hashCode()); // true
    }
}
