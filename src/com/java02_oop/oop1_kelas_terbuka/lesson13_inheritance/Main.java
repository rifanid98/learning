package com.java02_oop.oop1_kelas_terbuka.lesson13_inheritance;

import com.java02_oop.oop1_kelas_terbuka.lesson13_inheritance.inheritance.Avanza;
import com.java02_oop.oop1_kelas_terbuka.lesson13_inheritance.inheritance.Lamborghini;

public class Main {

    public static void main(String[] args) {
        Lamborghini lamborghini1 = new Lamborghini();
        lamborghini1.profile();
        lamborghini1.turbo();
        lamborghini1.go();
        System.out.println();

        Lamborghini lamborghini2 = new Lamborghini(true);
        lamborghini2.profile();
        lamborghini2.turbo();
        lamborghini2.go();
        System.out.println();

        Avanza avanza1 = new Avanza();
        avanza1.profile();
        avanza1.trunk();
        avanza1.go();
        System.out.println();

        Avanza avanza2 = new Avanza(true);
        avanza2.profile();
        avanza2.trunk();
        avanza2.go();
        System.out.println();
    }
}
