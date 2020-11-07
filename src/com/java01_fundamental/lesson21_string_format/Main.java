package com.java01_fundamental.lesson21_string_format;

public class Main {

    public static void main(String[] args) {
        /**
         * String Format
         */
        String name = "Adnin";
        int age = 22;
        float score = (float) 95.0;
        System.out.println("Hello, nama saya " + name + " umurku " + age + " punya nilai " + score);
        /* conversion */
        System.out.printf("Hello, nama saya %s umurku %d punya nilai %f \n", name, age, score);
        /* argument index */
        System.out.printf("Hello nama saya %1$s, biasa dipanggil %1$s, lalu umurku %2$d , dan nilaiku %3$f \n", name, age, score);
        /* flags */
        int a = 5;
        int b = 3;
        int c = a - b;
        int d = b - a;
        System.out.printf("%d - %d = %+d \n", a, b, c);
        System.out.printf("%d - %d = %+d \n", a, b, d);
        /* width */
        int number = 1000;
        String hobby = "Coding";
        System.out.printf("%5d\n", number);
        System.out.printf("%5d\n", number);
        System.out.printf("%8s\n", hobby);
        System.out.printf("%-8s\n", hobby); // flags - = rata kiri
        System.out.printf("%08d\n", number);
        System.out.printf("%,d\n", number); // flags , = delimiter with
        /*
            precision
            .n = . is precision flags, n is precision length
        */
        float floatToTopPrecision = 15.678f;
        float floatMidleToTopPrecision = 15.658f;
        float floatToBottomgPrecision = 15.648f;
        System.out.println("Precision one number after .");
        System.out.printf("default                 = %f\n", floatToTopPrecision);
        System.out.printf("precision to top        = %f %.1f\n",floatToTopPrecision, floatToTopPrecision);
        System.out.printf("precision middle to top = %f %.1f\n",floatMidleToTopPrecision, floatMidleToTopPrecision);
        System.out.printf("precision to bottom     = %f %.1f\n",floatToBottomgPrecision, floatToBottomgPrecision);
        System.out.println();
        System.out.println("Precision two number after .");
        System.out.printf("default                 = %f\n", floatToTopPrecision);
        System.out.printf("precision to top        = %f %.2f\n",floatToTopPrecision, floatToTopPrecision);
        System.out.printf("precision middle to top = %f %.2f\n",floatMidleToTopPrecision, floatMidleToTopPrecision);
        System.out.printf("precision to bottom     = %f %.2f\n",floatToBottomgPrecision, floatToBottomgPrecision);
    }
}
