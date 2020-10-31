package com.oop.lesson11_hierarchy_package;

/* Secara default, code kita akan dicompile dan apabila
 * terdapat beberapa class dalam 1 file, makan ketika
 * dicompile menjadi java.class, java akan memisahkan
 * class-class tersebut ke file-file yang terpisah
 * */
public class WithPackage {
    private String name;

    public WithPackage(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("Package Name\t: " + this.name);
    }
}
