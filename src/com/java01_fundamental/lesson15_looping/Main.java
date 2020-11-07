package com.java01_fundamental.lesson15_looping;

public class Main {

    public static void main(String[] args) {
        /**
         * Looping
         * while
         * do while
         * for
         */

        // while loop
        // check the argument first, then execute the code
        int i = 0;
        while (i <= 10) {
            System.out.println("i = " + i);
            i++;
        }

        //  do while
        // execute the code first, then check the argument
        // akan dieksekusi minimal 1 kali
        int j= 0;
        do {
            System.out.println("j = " + j);
            j++;
        } while (j <= 10);

        // for
        // argument & increment / decrement declarated in one line
        for (int k = 0; k <= 10; k++) {
            System.out.println("k = " + k);
        }

        /**
         * Break, Continue & Return
         * Break; menghentikan loop
         * Continue; melewatkan loop
         * Return; mengembalikan nilai
         */
        int m = 0;
        while (m <= 10) {
            m++;
            if (m == 5) {
                System.out.println("Loop ke 5 diskip");
                continue;
            }
            if (m == 9) {
                System.out.println("Loop ke 9, keluar dari loop");
                break;
                // return; // jika menggunakan return, makan program akan berhenti
            }
            System.out.println(m);
        }
        System.out.println("Outside of loop");
    }
}
