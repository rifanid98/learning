package com.java02_oop.oop2_programmer_zaman_now.lesson02_polymorphism;

public class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.printf("Hello Employee %s\n", this.name);
    }
}
