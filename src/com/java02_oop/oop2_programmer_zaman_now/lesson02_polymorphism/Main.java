package com.java02_oop.oop2_programmer_zaman_now.lesson02_polymorphism;

/**
 * Polymorphism
 *
 * object yang sudah diinstasiasi atau dideklarasikan
 * dapat berubah menjadi class yang lain dengan syarat
 * class tujuan untuk berubahnya itu sama dengan class
 * awal ketika dia diinstasiasi atau dibuat, atau harus
 * memilki sifat yang sama / inheritance.
 */
public class Main {

    public static void main(String[] args) {
        Employee employee = new Employee("Adnin");
        employee.sayHello();

        employee = new Manager("Adnin");
        employee.sayHello();

        employee = new VicePresident("Adnin");
        employee.sayHello();

        sayHello(new Employee("Rifandi"));
        sayHello(new Manager("Rifandi"));
        sayHello(new VicePresident("Rifandi"));
    }

    /**
     * Type Check and Cast
     * @param employee
     */
    static public void sayHello (Employee employee) {
        if (employee instanceof Manager) {
            Manager manager = (Manager) employee;
        } else if (employee instanceof VicePresident) {
            VicePresident vicePresident = (VicePresident) employee;
        }

        employee.sayHello();
    }
}
