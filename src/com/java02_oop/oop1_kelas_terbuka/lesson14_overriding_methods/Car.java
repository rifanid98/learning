package com.java02_oop.oop1_kelas_terbuka.lesson14_overriding_methods;

public class Car {
    String name;

    public Car(String name) {
        this.name = name;
    }

    public void carName() {
        System.out.println("Car Name\t:" + this.name);
    }
}
