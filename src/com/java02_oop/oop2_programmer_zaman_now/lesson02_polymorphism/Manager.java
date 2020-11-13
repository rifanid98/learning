package com.java02_oop.oop2_programmer_zaman_now.lesson02_polymorphism;

public class Manager extends Employee {

    Manager(String name) {
        super(name);
    }

    public void sayHello() {
        System.out.println("Hello Manager " + this.name);
    }
}
