package com.java02_oop.oop1_kelas_terbuka.lesson05_public_private_keyword;

class Person {
    String name;            // default -> +wr from inside or outside of class
    public int age;         // public  -> +wr from inside or outside of class
    private String address; // private -> +wr from inside of class; -wr from outside of class
    private int exp = 0;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address; // write access from inside of class
    }

    void display() {
        System.out.println("Name\t: " + this.name);
        System.out.println("Age\t\t: " + this.age);
        System.out.println("Address\t: " + this.address); // read access from inside of class
        System.out.println("Exp\t\t: " + this.exp);
        System.out.println();
        setExp(); // access private method inside of class
    }

    void setName(String name) {
        this.name = name;
    }

    private void setExp() {
        this.exp += 10;
    }
}

public class Main {

    public static void main(String[] args) {
        Person adnin = new Person("Adnin", 22);
        //adnin.address = "Kp. Sinagar" -> error, not accessible
        adnin.display();

        Person rifandi = new Person("Rifandi", 22, "Kp. Sinagar");
        rifandi.display();
        rifandi.setName("Rifandi Sutanto");
        rifandi.display();
    }
}
