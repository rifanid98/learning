package com.java02_oop.oop2_programmer_zaman_now.lesson14_stack_trace_element;

/**
 * StackTraceElement
 *
 * Untuk log error, mengetahui letak error di line berapa
 */
public class StackTraceElement1 {

    public static void main(String[] args) {
        try {
            String[] names = {"Adnin", "Rifandi", "Sutanto"};
            System.out.println(names[100]);
        } catch (Throwable t) {
            // manual print
            StackTraceElement[] stackTraceElements = t.getStackTrace();
            System.out.println(stackTraceElements[0]);
            System.out.println(stackTraceElements[1]);

            // print semua error
            t.printStackTrace();
        }
    }
}
