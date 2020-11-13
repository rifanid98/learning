package com.java02_oop.oop1_kelas_terbuka.lesson13_inheritance.inheritance;

public class Avanza extends Car {
    private boolean trunk = false;

    public Avanza() {
        super(
            "Casual",
            "Avanza",
            4
        );
    }

    public Avanza(boolean trunk) {
        super("Casual", "Avanza", 4);
        this.trunk = trunk;
    }

    public void trunk() {
        if (this.trunk) {
            System.out.println("Trunk opened!");
        } else {
            System.out.println("Trunk closed!");
        }
    }
}
