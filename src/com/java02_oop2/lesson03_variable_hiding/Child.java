package com.java02_oop2.lesson03_variable_hiding;

public class Child extends Parent {
    String name = "Child";

    public void doIt() {
        System.out.println("Do from child");
    }
}
