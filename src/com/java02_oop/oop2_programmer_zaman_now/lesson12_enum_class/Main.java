package com.java02_oop.oop2_programmer_zaman_now.lesson12_enum_class;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setName("Adnin");
        customer.setLevel(Level.STANDARD);
        System.out.println(customer.getName());
        System.out.println(customer.getLevel());
        System.out.println(customer.getLevel().getDescription());

        // get value of enum
        String levelName = Level.STANDARD.name();
        System.out.println(levelName);

        // get enum by string
        Level level = Level.valueOf("STANDARD");
        System.out.println(level);

        // get all enum options / methods
        Level[] levels = Level.values();
        for (var value: levels) {
            System.out.println("value of levels\t:" + value);
            
        }
    }
}
