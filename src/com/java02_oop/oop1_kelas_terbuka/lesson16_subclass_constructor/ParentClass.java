package com.java02_oop.oop1_kelas_terbuka.lesson16_subclass_constructor;

public class ParentClass {
    String name;

    /* ParentClass constructor */
    public ParentClass(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Name\t: " + this.name);
    }

}
