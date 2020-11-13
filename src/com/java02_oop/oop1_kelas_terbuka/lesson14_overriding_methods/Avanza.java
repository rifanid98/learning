package com.java02_oop.oop1_kelas_terbuka.lesson14_overriding_methods;

public class Avanza  extends Car {

    public Avanza(String name) {
        super(name);
    }

    /* Overriding Parent Method carName() */
    public void carName() {
        System.out.println("Show Car Name");
        System.out.println("Car Name\t: " + this.name);
    }
}
