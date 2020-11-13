package com.java02_oop.oop1_kelas_terbuka.lesson09_static_or_class_method;

import java.util.ArrayList;

class Gadget{
    private static String name;
    private static ArrayList<String> gadgetList = new ArrayList<String>();

    Gadget(String name) {
        this.name = name;
        Gadget.gadgetList.add(name);
    }
    /* static method */
    static void display() {
        System.out.println("Gadget name\t: " + Gadget.name);
    }

    static void getGadgetList() {
        System.out.println("Gadget List\t: \n" + Gadget.gadgetList);
    }
}

public class Main {

    public static void main(String[] args) {
        Gadget mobilePhone = new Gadget("Handphone");
        Gadget laptop = new Gadget("Laptop");
        Gadget computer = new Gadget("Personal Computer");
        Gadget smartBand = new Gadget("Smart Band");

        Gadget.getGadgetList();
    }
}
