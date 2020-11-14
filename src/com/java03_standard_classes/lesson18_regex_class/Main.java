package com.java03_standard_classes.lesson18_regex_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Regular Expression Class
 */
public class Main {

    public static void main(String[] args) {
        String name = "Adnin Rifandi Sutanto Putra Programmer Zaman Old";
        Pattern pattern = Pattern.compile("[a-zA-Z]*[a][a-zA-Z]*");
        Matcher matcher = pattern.matcher(name);

        while (matcher.find()) { // selama mather masih bisa menemukan data
            // kita print hasilnya
            String result = matcher.group();
            System.out.println(result);
        }
    }
}
