package com.java02_oop.oop2_programmer_zaman_now.lesson14_stack_trace_element;

/**
 * Multiple StackTraceElement
 */
public class StackTraceElement2 {

    public static void main(String[] args) {
        try {
            sampleError();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    static void sampleError() {
        try {
            String[] names = {"Adnin", "Rifandi", "Sutanto"};
            System.out.println(names[100]);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }
}
