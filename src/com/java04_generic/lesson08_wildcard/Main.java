package com.java04_generic.lesson08_wildcard;

import com.java04_generic.lesson07_multiple_bounded_type_parameter.Main.Manager;

public class Main {
    public static void main(String[] args) {
        print(new MyData<Integer>(100));
        print(new MyData<String>("Adnin"));
        print(new MyData<Manager>(new Manager()));
    }

    /**
     * Wildcard
     *
     * - Kadang ada kalanya kita tidak peduli dengan generic parameter type pada object
     * - Misal kita hanya ingin print data T, tidak peduli tipe apapun
     * - Jika kita mengalami kasus seperti ini, kita bisa menggunakan Wildcard
     * - Wildcard bisa dibuat dengan mengganti generic parameter type dengan karakter ?
     */
    public static void print(MyData<?> data) {
        Object o = data.getData();
        System.out.println(o);
    }
}
