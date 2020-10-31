package com.chapter02_oop.lesson10_multifile_import;

import com.chapter02_oop.lesson11_hierarchy_package.WithPackage;
import com.chapter02_oop.lesson10_multifile_import.terminal.Console;

public class Main {

    public static void main(String[] args) {
        /* WithPackage bisa diakses langsung
           karena berada di package yang sama */
        WithPackage withPackage = new WithPackage("With Package");
        withPackage.display();

        /* harus diimport dulu, karena beda package */
        Console.log("Hai");
    }
}
