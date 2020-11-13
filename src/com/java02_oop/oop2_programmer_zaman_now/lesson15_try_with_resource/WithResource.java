package com.java02_oop.oop2_programmer_zaman_now.lesson15_try_with_resource;

import java.io.BufferedReader;
import java.io.FileReader;

public class WithResource {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("README.md"))){
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (Throwable t) {
            System.out.println("Error membaca file\t:" + t.getMessage());
        }
    }
}
