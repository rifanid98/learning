package com.java02_oop2.lesson03_variable_overriding;

public class Child extends Parent {
    String name = "Child";

    public void doIt() {
        System.out.println("Do from child");
    }
}
