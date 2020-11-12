package com.java02_oop2.lesson08_final.final_method;

class Parent {
    final void display() {
        System.out.println("Hello");
    }
}

class Child extends Parent {
    /**
     * Error. tidak bisa override, karena sudah final
     * di class parent nya
     * public void display() {
     *
     * }
     */
}

public class Main {

}
