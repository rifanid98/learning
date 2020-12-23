package com.java06_lambda_expression.lesson06_lambda_di_optional;

import java.util.Optional;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        sayHello("Adnin");
        sayHelloNullSafe(null);
    }

    public static void sayHello(String name) {
        System.out.println("Hello " + name.toUpperCase());
    }

    public static void sayHelloNullSafe(String name) {
        /** Procedural Code */
        Optional<String> optionalName = Optional.ofNullable(name);
        /* With Anonymous Class */
        Optional<String> upperName1 = optionalName.map(new Function<String, String>() {
            @Override
            public String apply(String value) {
                return value.toUpperCase();
            }
        });
        /* With Lambda Expression */
        Optional<String> upperName2 = optionalName.map(value -> value.toUpperCase());
        //System.out.println("Hello " + upperName2); // akan tetap dipanggil walupun name nya null
        upperName2.ifPresent(value -> System.out.println("Hello " + value));

        /** Chaining Code */
        /* Lambda Expression */
        Optional.ofNullable(name)
                .map(n -> n.toUpperCase())
                .ifPresent(n -> System.out.println("Hello " + n));
        /* Lambda Expression Method Reference */
        Optional.ofNullable(name)
                .map(String::toUpperCase)
                .ifPresent(System.out::println);
        /* ifPresentOrElse */
        Optional.ofNullable(name)
                .map(String::toUpperCase)
                .ifPresentOrElse(
                    value -> System.out.println("Hello " + value),
                    () -> System.out.println("Hello ")
                );
        /* orElse */
        String name2 = Optional.ofNullable(name)
                .map(String::toUpperCase)
                .orElse("TEMAN");
        System.out.println("Hello " + name2);

    }
}
