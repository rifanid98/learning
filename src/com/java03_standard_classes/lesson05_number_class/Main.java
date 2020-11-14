package com.java03_standard_classes.lesson05_number_class;

public class Main {

    public static void main(String[] args) {
        /**
         * Konversi dari number ke number.
         * Karena tipe data integer yang bukan primitive,
         * semuanya extends ke class number
         */
        Integer intValue = 10;
        Long intLong = intValue.longValue();
        Double intDouble = intValue.doubleValue();
        Float intFloat = intValue.floatValue();
        // ...
        // ...

        /**
         * Konversi string ke angka
         */
        int valueInt1 = Integer.parseInt("1000"); // jika primitive (int) gunakan parseInt
        Integer valueInt2 = Integer.valueOf("10000"); // jika non primitive (Integer) gunakan valueOf
        Double valueInt3 = Double.valueOf("10.000"); // 10.000
    }
}
