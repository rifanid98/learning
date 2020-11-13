package com.java02_oop.oop2_programmer_zaman_now.lesson15_try_with_resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Manual {

    public static void main(String[] args) {
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("ADNIN.md"));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (Throwable t) {
            System.out.println("Error membaca file\t:" + t.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    System.out.println("Sukses menutup file");
                } catch (IOException e) {
                    System.out.println("Error menutup resource\t:" + e.getMessage());
                }
            }
        }
    }
}
