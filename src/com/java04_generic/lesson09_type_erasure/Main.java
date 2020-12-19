package com.java04_generic.lesson09_type_erasure;

public class Main {
    public static void main(String[] args) {
        MyData<String> stringMyData = new MyData<>("Adnin"); // no type erasure
        MyData myData = new MyData("Eko"); // type erasure, generic type parameternya dihapus


//        MyData<Integer> integerMyData1 = (MyData<Integer>) stringMyData; // langsung error ketika compile, dan lebih aman (no type erasure)
        MyData<Integer> integerMyData2 = (MyData<Integer>) myData; // aman saat compile, namun error saat running, ini efek dari type erasure
//        integerMyData2.setData(1000);
        Integer integer = integerMyData2.getData();
    }
}
