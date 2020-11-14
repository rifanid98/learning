package com.java03_standard_classes.lesson16_properties_class;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("application.properties"));

            System.out.println("DB Host\t\t: " + properties.getProperty("db_host"));
            System.out.println("DB Port\t\t: " + properties.getProperty("db_port"));
            System.out.println("DB User\t\t: " + properties.getProperty("db_user"));
            System.out.println("DB Password\t: " + properties.getProperty("db_password"));

            properties.put("key", "value"); // add new properties
            properties.store(new FileOutputStream("application.properties") , "add comments here");
        } catch (IOException e) {
            System.out.println("File tidak ketemu");
            e.printStackTrace();
        }
    }
}
