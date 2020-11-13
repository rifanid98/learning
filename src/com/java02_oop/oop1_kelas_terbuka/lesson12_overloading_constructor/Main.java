package com.java02_oop.oop1_kelas_terbuka.lesson12_overloading_constructor;

/*
 * Overloading
 *
 * Membuat method yang sama dengan parameter yang berbeda.
 * Overloading bisa dibuat untuk method biasa atau method
 * constructor.
 */

class People {
    String name;
    int age;
    String address = "Doesn't have any address";

    /**
     * Main Constructor
     * need:
     * @param name string
     * @param age integer
     */
    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Overloading Constructor 1
     * need:
     * @param name string
     * @param age integer
     * @param address string
     */
    public People(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    /**
     * Main Method
     */
    public void profile() {
        System.out.printf("Name\t: %s\n", this.name);
        System.out.printf("Age\t\t: %d\n", this.age);
    }

    /**
     * Overloading Method 1
     * need:
     * @param address string
     */
    public void profile(boolean address) {
        System.out.printf("Name\t: %s\n", this.name);
        System.out.printf("Age\t\t: %d\n", this.age);
        if (address) {
            System.out.printf("Address\t: %s\n", this.address);
        }
    }
}

public class Main {

    public static void main(String[] args) {
        People adnin = new People("Adnin", 22);
        adnin.profile();

        System.out.println();

        People rifandi = new People("Rifandi", 22, "Kp. Sinagar");
        rifandi.profile(true);
    }
}
