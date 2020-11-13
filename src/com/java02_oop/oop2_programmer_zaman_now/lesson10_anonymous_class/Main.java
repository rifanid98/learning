package com.java02_oop.oop2_programmer_zaman_now.lesson10_anonymous_class;

interface HelloWorld {
    void sayHello();
    void sayHello(String name);
}

public class Main {

    public static void main(String[] args) {
        /**
         * Anonymous Class.
         * Anonymous class tak bisa direuse
         */
        HelloWorld helloWorldEnglish = new HelloWorld() {
            @Override
            public void sayHello() {
                System.out.println("Hello ");
            }

            @Override
            public void sayHello(String name) {
                System.out.println("Hello " + name);
            }
        };

        helloWorldEnglish.sayHello();
        helloWorldEnglish.sayHello("Adnin");

        HelloWorld helloWorldIndo = new HelloWorld() {
            @Override
            public void sayHello() {
                System.out.println("Halo ");
            }

            @Override
            public void sayHello(String name) {
                System.out.println("Halo " + name);
            }
        };

        helloWorldIndo.sayHello();
        helloWorldIndo.sayHello("Adnin");
    }
}
