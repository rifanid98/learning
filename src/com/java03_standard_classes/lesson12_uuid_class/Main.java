package com.java03_standard_classes.lesson12_uuid_class;

import java.util.UUID;

/**
 * UUID = Universally Unique Identifier
 */
public class Main {

    public static void main(String[] args) {
        for (var i = 0; i < 10; i++) {
            System.out.println(UUID.randomUUID().toString());
        }
    }
}
