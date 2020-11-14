package com.java03_standard_classes.lesson02_string_buffer_and_builder_class;

public class Main {

    public static void main(String[] args) {
        /**
         * String Builder
         */
        StringBuilder name = new StringBuilder();
        name.append("Adnin ");
        name.append("Rifandi ");
        name.append("Sutanto ");
        name.append("Putra ");
        name.toString();
        System.out.println(name);
    }
}
