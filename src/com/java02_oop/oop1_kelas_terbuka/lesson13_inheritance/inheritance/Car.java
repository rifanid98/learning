package com.java02_oop.oop1_kelas_terbuka.lesson13_inheritance.inheritance;

public class Car extends Vehicle {
    private String carType;
    private String carName;
    private int carWheel;

    public Car(
            String carType,
            String carName,
            int carWheel
    ) {
        super("Land");
        this.carType = carType;
        this.carName = carName;
        this.carWheel = carWheel;
    }

    public void go() {
        System.out.println(this.carName + " car drove");
    }

    public void profile() {
        System.out.println("Car Profile");
        System.out.println("Name\t: " + this.carName);
        System.out.println("Type\t: " + this.carType);
        System.out.println("Wheel\t: " + this.carWheel);
    }
}
