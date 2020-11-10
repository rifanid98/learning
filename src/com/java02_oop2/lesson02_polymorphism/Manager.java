package com.java02_oop2.lesson02_polymorphism;

public class Manager extends Employee {

    Manager(String name) {
        super(name);
    }

    public void sayHello() {
        System.out.println("Hello Manager " + this.name);
    }
}
