package com.java02_oop.oop1_kelas_terbuka.lesson03_methods;

class Method {
    String string;
    int integer;

    Method(String string, int integer) {
        this.string = string;
        this.integer = integer;
    }

    // method tanpa return tanpa parameter
    void printData() {
        System.out.println("printData(): " + this.string + " " + this.integer);
    }

    //method tanpa return dengan parameter
    void printData2(String string) {
        this.string = string;
        System.out.println("printData2(): " + this.string + " " + this.integer);
    }

    // method dengan return tanpa parameter
    String showData() {
        return "showData() " + this.string + " " + this.integer;
    }

    // method dengan return dengan parameter
    String showData2(String string) {
        this.string = string;
        return "showData2() " + this.string + " " + this.integer;
    }
}

public class Main {

    public static void main(String[] args) {
        Method method = new Method("String", 100);
        method.printData();
        method.printData2("String");
        System.out.println(method.showData());
        System.out.println(method.showData2("String"));
    }
}
