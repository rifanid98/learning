package com.java02_oop2.lesson06_interface;

public interface ILegal {
    void legal();

    /**
     * Default Method in interface.
     * or
     * Optional method in interface
     */
    default void tkdn() {
        System.out.println("tkdn exists");
    }
}
