package com.java03_standard_classes.lesson04_string_tokenizer_class;

import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        String name = "Adnin Rifandi Sutanto Putra";
        StringTokenizer nameTokens = new StringTokenizer(name, " ");

        while (nameTokens.hasMoreTokens()) {
            String nameToken = nameTokens.nextToken();
            System.out.println(nameToken);
        }
    }
}
