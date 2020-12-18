package com.java04_generic.lesson03_invariant;

public class Main {
    public static void main(String[] args) {
        MyData<String> stringMyData = new MyData<>("Adnin");
//        MyData<Object> objectMyData = myDataString; // error tidak bisa disubtitute

        MyData<Object> objectMyDataInt = new MyData<>(22);
//        MyData<Integer> integerMyData = objectMyDataInt; // error tidak bisa disubtitute

//         doIt(stringMyData); // error, tidak bisa disubtitute
    }

    public static void doIt(MyData<Object> objectMyData) {
        // do nothing
    }
}
