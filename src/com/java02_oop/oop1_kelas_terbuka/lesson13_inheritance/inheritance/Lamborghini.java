package com.java02_oop.oop1_kelas_terbuka.lesson13_inheritance.inheritance;

public class Lamborghini extends Car {
    private boolean turbo = false;

    public Lamborghini() {
        super(
            "Sport",
            "Lamborghini",
            4
        );
    }

    public Lamborghini(boolean turbo) {
        super(
            "Sport",
            "Lamborghini",
            4
        );
        this.turbo = turbo;
    }

    public void turbo() {
        if (this.turbo) {
            System.out.println("Turbo activated!");
        } else {
            System.out.println("Turbo deactivated!");
        }
    }
}