package com.java02_oop2.lesson02_polymorphism;

public class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.printf("Hello Employee %s\n", this.name);
    }
}
