package com.java06_lambda_expression.lesson01_membuat_lambda;

public class Main {
    public static void main(String[] args) {
        /**
         * Lambda Interface without parameter
         */
        /* anonymous class */
        SimpleAction lambda = new SimpleAction() {
            @Override
            public String action() {
                return "Adnin";
            }
        };

        System.out.println(lambda.action());

        /* lambda expression */
        SimpleAction simpleAction2 = () -> {
            return "Adnin";
        };

        /**
         * Lambda Interface with parameter
         */
        /* anonymous class */
        SimpleActionParam lambdaParam1 = new SimpleActionParam() {
            @Override
            public String action(String name) {
                return name;
            }
        };

        System.out.println(lambdaParam1.action("Adnin"));

        /* lambda expression */
        // cara 1
        SimpleActionParam lambdaParam2 = (String name) -> {
            return name;
        };
        // cara 2
        SimpleActionParam lambdaParam3 = (name) -> {
            return name;
        };

        /**
         * Lambda tanpa blok kode
         *
         * Digunakan ketika kita membuat lambda expression
         * tapi hanya satu baris kode
         */
        // cara 1
        SimpleAction lambdaOneLine1 = () -> "Adnin";
        // cara 2
        SimpleActionParam lambdaOneLine2 = (String name) -> name;
        // cara 3
        SimpleActionParam lambdaOneLine3 = (name) -> name;
        // cara 4
        SimpleActionParam lambdaOneLine4 = name -> name;
    }
}
