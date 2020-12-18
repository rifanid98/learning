package com.java04_generic.lesson01_generic_class;

public class Main {
    public static void main(String[] args) {
        /** Single Parameter Type */
        GenericClass<String> genericClassStr = new GenericClass<String>("Adnin");
        GenericClass<Integer> genericClassInt = new GenericClass<Integer>(10);

        System.out.println(genericClassStr.getData());
        System.out.println(genericClassInt.getData());

        /** Multiple Parameter Type */
        PairClass<String, Integer> pairClassStrInt = new PairClass<String, Integer>("0", 0);
        PairClass<Integer, String> pairClassIntStr = new PairClass<Integer, String>(0, "0");

        System.out.println(pairClassStrInt.getFirst());
        System.out.println(pairClassStrInt.getSecond());
        System.out.println(pairClassIntStr.getFirst());
        System.out.println(pairClassIntStr.getSecond());
    }
}
