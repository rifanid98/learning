package com.java04_generic.lesson02_generic_method;

public class Main {
    public static void main(String[] args) {
        String[] names = {"Adnin", "Rifandi", "Sutanto", "Putra"};
        Integer[] ages = {22, 23, 24};

        System.out.println(GenericMethod.<String>count(names)); // bisa ditampilkan generic typenya
        System.out.println(GenericMethod.count(ages)); // bisa juga tidak
    }
}
