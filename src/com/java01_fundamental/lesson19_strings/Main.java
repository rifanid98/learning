package com.java01_fundamental.lesson19_strings;

public class Main {

    public static void main(String[] args) {
        /**
         * String
         * String it's same as array; String have an index,
         * but to use the index, is using charAt(n)
         *
         * Tetapi element string itu hanya bisa diakses,
         * tidak bisa diubah (read only) atau immutable
         */

        /** String charAt(n) */
        String name = "Adnin";
        System.out.println(name.charAt(0));
        System.out.println(name.charAt(1));
        System.out.println(name.charAt(2));
        System.out.println(name.charAt(3));
        System.out.println(name.charAt(4));

        /** String substring */
        String address = "Pasar Rebo";
        System.out.println(address.substring(0, 5)); // get 5 characters of string start from index 0

        /**
         * String Pool
         *
         * Java akan menyimpan variable dengan nilai yang sama,
         * di satu lokasi memory, begitu nilainya diubah dan berbeda,
         * maka java akan memindahkan nilai yang baru tadi ke
         * alamat memory yang berbeda.
         *
         * Tapi ketika ada dua variable string dengan nilai yang sama,
         * namun dihasilkan dengan cara yang berbeda, maka java
         * akan memberikan masing-masing variable dengan alamat
         * memory yang berbeda.
         */
        String name1 = "Adnin";
        String name2 = "Adnin";
        String name3 = "AAdnin".substring(1, 5);
        System.out.println("name1 = " + System.identityHashCode(name1));
        System.out.println("name2 = " + System.identityHashCode(name2));
        System.out.println("name3 = " + System.identityHashCode(name3));
        name2 = "ADnin";
        System.out.println("name2 = " + System.identityHashCode(name2));

        /**
         * Conclusion:
         *
         * 1. String itu immutable.
         * 2. String yang berada di string pool, itu reusable. Memorynya
         *    lebih efisien.
         * 3. Membuat string dengan method atau cara yang baru/berbeda,
         *    maka akan dialokasikan di memory yang lain, dan bukan di
         *    string pool
         */

        /**
         * String Method
         */
        String myName = "Adnin Rifandi Sutanto Putra";

        /* mengambil element dari string pada index tertentu */
        System.out.println(myName.charAt(0)); // A

        /* substring */
        System.out.println(myName.substring(0, 5)); // Adnin

        /* concatenation (concat) */
        // menggabungkan 1 atau lebih string
        String welcome = "Welcome";
        System.out.println(welcome + " " + myName); // Welcome Adnin
        // menggabungkan string dengan angka
        System.out.println(welcome + " " + myName + " " + 10); // casting, ubah int menjadi string

        /* lowercase UPPERCASE */
        System.out.println(myName);
        System.out.println(myName.toUpperCase());
        System.out.println(myName.toLowerCase());

        /* replace string */
        // karena menggunakan method pada string,akan disimpan di memory yang baru, maka nilainya harus disimpan di variable
        String myName2 = myName.replace("Rifandi", "RIFANDI");
        System.out.println(myName2);

        /* equality / persamaan */
        String string1 = "Adnin";
        String string2 = "Adnin";
        System.out.println(string1 == string2); // true, karena string pool. memory ditempatkan di alamat yang sama

        String newString1 = "Rifandi";
        String newString2 = new String("Rifandi");
        System.out.println(newString1 == newString2); // false, beda memory walaupun value sama, tetap dianggap tidak sama. jadi harus identik di memory yang sama pula

        String compareString1 = "Sutanto";
        String compareString2 = new String("Sutanto");
        System.out.println(compareString1.equals(compareString2)); // hanya mencocokan nilai, tidak mencocokan alamat memory
    }
}
