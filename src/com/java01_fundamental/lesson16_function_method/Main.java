package com.java01_fundamental.lesson16_function_method;

public class Main {

    public static void main(String[] args) {
        System.out.println(sum(2,2));
        recursive((1));
    }

    /**
     *
     * @param a integer
     * @param b integer
     * @return integer
     *
     * public static int sum()
     * penjelasan:
     * public = access modifier
     * static =
     * int = return data type
     * sum() = method name
     */
    public static int sum(int a, int b) {
        int hasil = a + b;
        return hasil;
    }

    /**
     * void = tidak mengembalikan/mereturn nilai apapun
     */
    public static void print() {
        System.out.println("void");
    }

    /**
     * Recursive Method
     * Function Recursive
     * Call function itself
     *
     * void = not returning anything
     */
    public static void recursive(int number) {
        if (number >= 20) {
            System.out.println("last number = " + number);
            return;
        }
        System.out.println("number = " + number);
        recursive(number + 1);
    }
}
