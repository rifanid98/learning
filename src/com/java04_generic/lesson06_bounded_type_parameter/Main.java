package com.java04_generic.lesson06_bounded_type_parameter;

public class Main {
    public static void main(String[] args) {
        NumberData<Integer> integerNumberData = new NumberData<>(2);
        NumberData<Long> longNumberData = new NumberData<>(1L);

        //NumberData<String> stringNumberData = new NumberData<String>("Adnin"); // error, karena string bukan subtype / child dari Object Number
    }
}
