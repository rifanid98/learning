package com.java05_collection.lesson21_default_method.List;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            numbers.add(i);
        }

        System.out.println(numbers);

        numbers.replaceAll(new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                //return 2; tiap data direplace menjadi angka 2
                return integer-1; // tiap data dikurangi 1 angka
            }
        });

        System.out.println(numbers);

        numbers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        numbers.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 500;
            }
        });

        System.out.println(numbers);
    }
}
