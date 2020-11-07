package com.java01_fundamental.lesson20_string_builder;

import java.lang.StringBuilder;

public class Main {

    public static void main(String[] args) {
        /**
         * String Builder
         * Mengolah data string tanpa harus menggunakan memory yang
         * berbeda
         */
        StringBuilder stringBuilder = new StringBuilder("Adnin");
        System.out.println("String   = " + stringBuilder);
        System.out.println("Memory   = " + System.identityHashCode(stringBuilder));
        System.out.println("Length   = " + stringBuilder.length());
        System.out.println("Capacity = " + stringBuilder.capacity());
        System.out.println();

        /** Append */
        stringBuilder.append(" Sutanto");
        System.out.println("String = " + stringBuilder);
        System.out.println("Memory = " + System.identityHashCode(stringBuilder));
        System.out.println("Length   = " + stringBuilder.length());
        System.out.println("Capacity = " + stringBuilder.capacity());
        System.out.println();

        /** Insert */
        stringBuilder.insert(5," Rifandi");
        System.out.println("String = " + stringBuilder);
        System.out.println("Memory = " + System.identityHashCode(stringBuilder));
        System.out.println("Length   = " + stringBuilder.length());
        System.out.println("Capacity = " + stringBuilder.capacity());
        System.out.println();

        /** Delete */
        stringBuilder.delete(14, (14+7));
        System.out.println("String = " + stringBuilder);
        System.out.println("Memory = " + System.identityHashCode(stringBuilder));
        System.out.println("Length   = " + stringBuilder.length());
        System.out.println("Capacity = " + stringBuilder.capacity());
        System.out.println();

        /** Set Char */
        stringBuilder.setCharAt(0, 'a');
        System.out.println("String = " + stringBuilder);
        System.out.println("Memory = " + System.identityHashCode(stringBuilder));
        System.out.println("Length   = " + stringBuilder.length());
        System.out.println("Capacity = " + stringBuilder.capacity());
        System.out.println();

        /** Replace */
        stringBuilder.replace(0, 2,"AD");
        System.out.println("String = " + stringBuilder);
        System.out.println("Memory = " + System.identityHashCode(stringBuilder));
        System.out.println("Length   = " + stringBuilder.length());
        System.out.println("Capacity = " + stringBuilder.capacity());
        System.out.println();

        /** Casting to String */
        String stringify = stringBuilder.toString();
        System.out.println("String = " + stringify);
        System.out.println("Memory = " + System.identityHashCode(stringify));
        System.out.println("Length   = " + stringify.length());
        System.out.println("Capacity = string doesn't have capacity");
        System.out.println();
    }
}
