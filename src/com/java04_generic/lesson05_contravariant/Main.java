package com.java04_generic.lesson05_contravariant;

public class Main {
    public static void main(String[] args) {
        MyData<Object> objectMyData = new MyData<>("Adnin");
        MyData<? super String> stringMyData = objectMyData; // ini bisa, karena contravariant
        //objectMyData.setData(1000);

        doIt(objectMyData); // ini juga boleh
    }

    /**
     * Contravariant itu wirte dan read.
     *
     * Contravariant :
     * - getData tidak aman
     * - setData aman
     * */
    public static void doIt(MyData<? super String> myData) {
        //String value = myData.getData(); // error
        String value = (String) myData.getData(); // tidak error, karena dipaksa dengan metode casting
        myData.setData("Rifandi");

        /**
         * Namun ketika kita melakukan ini, ini akan terjadi error
         * apabila kita melakukan setData menjadi selain string,
         * contohnya dengan integer, maka ketika program dijalankan
         * akan terjadi error conversion dari Integer ke string.
         *
         * (uncomment line 7 untuk melihat errornya)
         */
    }
}
