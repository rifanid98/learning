package com.oop;

class ClassObject {
    String name;
    int age;
}

public class ClassAndObject {

    public static void main(String[] args) {
        ClassObject person = new ClassObject();
        person.name = "Adnin";
        person.age = 22;
        System.out.println(person.name);
        System.out.println(person.age);
    }
}
