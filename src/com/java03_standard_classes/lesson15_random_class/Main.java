package com.java03_standard_classes.lesson15_random_class;

import java.util.Random;

/**
 * Random Class
 *
 * kita bisa membuat random number dengan class ini
 */
public class Main {

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int value = random.nextInt(1000); // angka maksimalnya
            System.out.println(value);
        }
    }
}
