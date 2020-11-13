package com.java02_oop.oop2_programmer_zaman_now.lesson06_interface;

public class Main {

    public static void main(String[] args) {
        /**
         * ICar doesn't have method legal()
         */
        ICar car = new Avanza();
        System.out.println(car.getTier());
        car.start();
        car.drive();
        car.stop();
        System.out.println();

        /**
         * Class Avanza have method legal()
         * Class Avanza have method tkdn();
         */
        Avanza car2 = new Avanza();
        car2.tkdn();
        car2.legal();
        System.out.println(car2.getTier());
        car2.start();
        car2.drive();
        car2.stop();
    }
}
