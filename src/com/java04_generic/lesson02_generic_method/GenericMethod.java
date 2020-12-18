package com.java04_generic.lesson02_generic_method;

public class GenericMethod {
    public static <T> int count(T[] array) {
        return array.length;
    }
}