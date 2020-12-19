package com.java04_generic.lesson04_covariant;

public class Main {
    public static void main(String[] args) {
        MyData<String> stringMyData = new MyData<>("Adnin");
        doIt(stringMyData); // error, tidak bisa disubtitute

        MyData<? extends Object> myData = stringMyData; // boleh, karena covariant
    }

    /**
     * Covariant itu readonly, ketika sudah dibuat maka datanya menjadi
     * covariant, tidak bisa diubah lagi dengan value yang lain
     *
     * Covariant :
     * - getData aman
     * - setData tidak aman
     * */
    public static void doIt(MyData<? extends Object> objectMyData) {
        System.out.println(objectMyData.getData());
//        objectMyData.setData("Rifandi"); // error
    }
}
