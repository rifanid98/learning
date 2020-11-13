package com.java02_oop.oop2_programmer_zaman_now.lesson01_call_other_constructor;

class Person extends Object {
    private String name;
    private String address;

    Person(String name, String address) {
        /**
         * Calling other constructor
         */
        this(name);
        // this.name = name;    // tidak perlu lagi set name, karena sudah dilakukan dengan
                                // memanggil constructor yang lain
        this.address = address;
    }

    Person(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Name\t: " + this.name);
        System.out.println("Address\t: " + this.address);
    }
}

public class Main {

    public static void main(String[] args) {
        Person person = new Person("Adnin", "Sinagar");
        person.display();
    }
}
