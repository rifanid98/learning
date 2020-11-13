package com.java02_oop.oop1_kelas_terbuka.lesson15_super;

public class ParentClass {
    public String name;
    public int age;
    public String memory;

    public ParentClass() {
        this.name = "Parent Class";
        this.age = 0;
        this.memory = Integer.toHexString(System.identityHashCode(this));
    }
}
