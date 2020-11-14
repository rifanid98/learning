package com.java03_standard_classes.lesson14_objects_class;

import java.util.Objects;

/**
 * Objects class (not Object class)
 *
 * Objects class ini mirip seperti Object di javascript:
 * Object.keys(obj);
 */
public class Main {

    public static void main(String[] args) {
        // execute(null); //nullPointerException
        execute(new MyObjects.Data("Adnin")); // running well
        executeWithCheck(null); // nothing happen

        executeWithObjects(null); // running well
        executeWithObjects(new MyObjects.Data("Adnin Rifandi")); // running well
    }

    public static void execute(MyObjects.Data data) {
        System.out.println("execute() ----------------");
        System.out.println(data.toString());
        System.out.println(data.hashCode());
        System.out.println();
    }

    public static void executeWithCheck(MyObjects.Data data) {
        if (data != null) {
            System.out.println("executeWithCheck() ----------------");
            System.out.println(data.toString());
            System.out.println(data.hashCode());
            System.out.println();
        }
    }

    public static void executeWithObjects(MyObjects.Data data) {
        System.out.println("executeWithObjects() ----------------");
        System.out.println(Objects.toString(data));
        System.out.println(Objects.hashCode(data));
        System.out.println();
    }
}
