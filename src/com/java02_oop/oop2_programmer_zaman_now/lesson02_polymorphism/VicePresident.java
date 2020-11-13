package com.java02_oop.oop2_programmer_zaman_now.lesson02_polymorphism;

public class VicePresident extends Employee {

    VicePresident(String name) {
        super(name);
    }

    public void sayHello() {
        System.out.println("Hello Vice President " + this.name);
    }
}
