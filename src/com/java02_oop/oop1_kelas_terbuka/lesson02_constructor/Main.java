package com.java02_oop.oop1_kelas_terbuka.lesson02_constructor;

class WithoutConstructor {
    String string;
    int integer;
}

class WithConstructor {
    String string;
    int integer;

    WithConstructor(String iString, int iInteger) {
        string = iString;
        integer = iInteger;
    }
}

public class Main {

    public static void main(String[] args) {
        classWithoutConstructor();
        classWithConstructor();
    }

    public static void classWithoutConstructor() {
        WithoutConstructor withoutConstructor = new WithoutConstructor();
        withoutConstructor.string = "String";
        withoutConstructor.integer = 100;
        System.out.println(withoutConstructor.string);
        System.out.println(withoutConstructor.integer);
        System.out.println();
    }

    public static void classWithConstructor() {
        WithConstructor withConstructor = new WithConstructor("String", 100);
        System.out.println(withConstructor.string);
        System.out.println(withConstructor.integer);
        System.out.println();
    }
}
