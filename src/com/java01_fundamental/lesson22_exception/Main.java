package com.java01_fundamental.lesson22_exception;

public class Main {

    public static void main(String[] args) {
        /**
         * Exception
         */
        try {
            int[] testArray = {1,2};
            testArray[3] = 4;
            System.out.println(testArray);
        } catch (ArrayIndexOutOfBoundsException error) {
            System.err.println("Index tidak ditemukan");
        } finally {
            System.out.println("Baris kode ini akan selalu dijalankan");
        }
    }
}
