package com.java02_oop.oop1_kelas_terbuka.lesson15_super;

public class ChildClass extends ParentClass {
    String name;
    int age;

    public ChildClass() {
        this.name = "Child Class";
        this.age = 10;
    }

    public void display() {
        System.out.println("ChildClass Name\t\t: " + this.name); // akan menggunakan property name milik ChildClass, karena property ini ada di ChildClass.
        System.out.println("ChildClass Age\t\t: " + this.age); // akan menggunakan property age milik ChildClass, karena property ini ada di ChildClass.
        System.out.println("ParentClass Name\t: " + super.name);    // super.name akan menggunakan property name dari ParentClass.
        System.out.println("ParentClass Age\t\t: " + super.age);    // super.age akan menggunakan property age dari ParentClass.
        System.out.println("Looking Nearby Memory\t: " + this.memory); // akan menggunakan property memory milik ParentClass, karena di ChildClass tidak ada.
    }
}
