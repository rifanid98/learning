package com.java02_oop.oop2_programmer_zaman_now.lesson04_abstract_class;

/**
 * Semua yang menggunakan abstract class, maka class
 * tersebut harus melaksanakan kontrak yang sudah dibuat
 * di abstract class. Baik abstract class tersebut,
 * property ataupun methodnya.
 */
public class Map extends Location {
    public String name; // implement of abstract property

    Map(String name) {
        this.name = name;
    }

    // implement of abstract method
    public void display() {
        System.out.println(this.name);
    }
}
