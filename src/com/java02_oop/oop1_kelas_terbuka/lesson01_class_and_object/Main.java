package com.java02_oop.oop1_kelas_terbuka.lesson01_class_and_object;

class ClassObject {
    String name;
    int age;
}

public class Main {

    public static void main(String[] args) {
        ClassObject person = new ClassObject();
        person.name = "Adnin";
        person.age = 22;
        System.out.println(person.name);
        System.out.println(person.age);
    }
}
