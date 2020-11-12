package com.java02_oop2.lesson06_interface;

public class Avanza implements ICar, ILegal {

    @Override
    public void drive() {
        System.out.println("Avanza Drove");
    }

    @Override
    public int getTier() {
        return 4;
    }

    @Override
    public void start() {
        System.out.println("Avanza Started");
    }

    @Override
    public void stop() {
        System.out.println("Avanza Stopped");
    }

    @Override
    public void legal() {
        System.out.println("This Vehicle is Legal");
    }

    @Override
    public void tkdn() {
        System.out.println("TKDN is True");
    }
}
