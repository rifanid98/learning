package com.java02_oop.oop1_kelas_terbuka.lesson16_subclass_constructor;

public class Main {

    public static void main(String[] args) {
        ParentClass object1 = new ParentClass("Object 1");  // menggunakan ParentClass constructor
        object1.display();

        ChildClass object2 = new ChildClass("Object 2");    // menggunakan ChildClass constructor
        object2.display();
    }
}
