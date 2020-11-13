package com.java02_oop.oop2_programmer_zaman_now.lesson03_variable_hiding;

/**
 * Variable Hiding.
 *
 * Ketika membuat variable yang sama, yang sudah dibuat
 * di parent class, maka variable atau properti tersebut
 * tidak akan diakses, melainkan yang diakses adalah
 * variable parent nya. Karena di java tidak ada field
 * overriding atau variable overriding. Adanya adalah
 * method overriding.
 */
public class Main {

    public static void main(String[] args) {
        Child child = new Child();
        child.name = "Child";

        Parent parent = (Parent) child;

        System.out.println(child.name);
        System.out.println(parent.name);

        child.doIt();
        parent.doIt();
    }
}
