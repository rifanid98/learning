package com.java01_fundamental.lesson02_data_type_declaration;

public class Main {
    private String name;

    public static void main(String[] args) {
        /*
        Primitive Data Type:
        -   int
        -   byte
        -   short
        -   long
        -   double
        -   float
        -   char
        -   boolean
         */
        int a; byte b; short c;
        long d; double e; float f;
        char g; boolean h;

        int myInteger = 10;

        System.out.println("=========INTEGER==========");
        System.out.println("nilai integer " + myInteger);
        System.out.println("nilai max     " + Integer.MAX_VALUE);
        System.out.println("besar integer " + Integer.BYTES);
        System.out.println("besar integer " + Integer.BYTES);
        System.out.println("nilai min     " + Integer.MIN_VALUE);
        System.out.println("besar integer " + Integer.SIZE);

        System.out.println("=========BYTE==========");
        System.out.println("nilai integer " + myInteger);
        System.out.println("nilai max     " + Integer.MAX_VALUE);
        System.out.println("besar integer " + Integer.BYTES);
        System.out.println("besar integer " + Integer.BYTES);
        System.out.println("nilai min     " + Integer.MIN_VALUE);
        System.out.println("besar integer " + Integer.SIZE);
    }
}
