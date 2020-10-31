package com.oop.lesson11_hierarchy_package;

import com.oop.lesson11_hierarchy_package.terminal.Console;
import static com.oop.lesson11_hierarchy_package.terminal.Console.log;

/*
 * access modifier dari class :
 * - default
 * - public
 *
 * apabila menggunakan default:
 * class ClassName {}, ClassName hanya bisa diakses di package yang sama saja
 * apabila menggunakan public:
 * public class ClassName {}, ClassName bisa diakses di luar package juga.
 *
 * satu file java hanya bisa ada 1 public class, sisanya default.
 */
public class Main {

    public static void main(String[] args) {
        /* access public class inside same package */
        WithPackage withPackage = new WithPackage("With Package");
        withPackage.display();

        /* access public class (com.oop.lesson10_multifile_import.terminal package) in com.oop package */
        Console.log("Console.log");

        /* access static method of Console class (com.oop.lesson10_multifile_import.terminal package)
           in com.oop package */
        log("Console.log static import");
    }
}
