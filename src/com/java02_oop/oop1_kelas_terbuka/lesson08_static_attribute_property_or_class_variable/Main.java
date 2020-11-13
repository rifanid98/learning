package com.java02_oop.oop1_kelas_terbuka.lesson08_static_attribute_property_or_class_variable;

/**
 * Static Attribute == Class Variable
 * Bisa diakses oleh semua object yang merupakan instance dari class tersebut.
 * Mirip seperti object reference, semuanya terkena dampak.
 */
/*
 *                               class -> static int myNum = 0;
 *                                 |
 *           --------------------------------------------
 *           |             |              |             |
 *       instance1     instance2      instance3     instance4
 *           |             |              |             |
 *       myNum-> 0      myNum-> 0     myNum-> 0     myNum = 100;
 *           |             |              |             |
 *       myNum-> 100    myNum-> 100   myNum-> 100   myNum = 100;
 */

class Monitor {
    static String staticAttribute = "Display";
    private String name;
    private String vendor;

    public Monitor(String name, String vendor) {
        this.name = name;
        this.vendor = vendor;
    }

    public void display() {
        System.out.println("Monitor");
        System.out.println("-------");
        System.out.println("Name\t: " + this.name);
        System.out.println("Vendor\t: " + this.vendor);
    }

    public void setStaticAttribute(String staticAttributeValue) {
        /* Cara penulisannya ada beberapa cara */
        /*
            1. staticAttribute = staticAttributeValue;
            2. this.staticAttribute = staticAttributeValue;
            3. Monitor.staticAttribute = staticAttributeValue; -> dengan menyebutkan nama class nya.
         */
        Monitor.staticAttribute = staticAttributeValue; // lebih recommended.
    }

    public void getStaticAttribute() {
        System.out.println("Static Attribute\t: " + this.staticAttribute);
    }
}


public class Main {

    public static void main(String[] args) {
        Monitor samsung = new Monitor("SAGJHS01", "SAMSUNG");
        samsung.display();
        samsung.getStaticAttribute();

        System.out.println();

        Monitor xiaomi = new Monitor("MIXAWDD", "XIAOMI");
        xiaomi.display();
        xiaomi.getStaticAttribute();

        System.out.println();

        samsung.staticAttribute = "xx"; // ketika diubah, semuanya ikut berubah
        samsung.display();
        samsung.getStaticAttribute();   // ini berubah jadi xx

        System.out.println();
        xiaomi.display();
        xiaomi.getStaticAttribute();    // ini juga berubah jadi xx
    }
}
