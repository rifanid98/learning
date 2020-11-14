package com.java03_standard_classes.lesson08_scanner_class;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama\t:\s");
        String name = scanner.nextLine();

        System.out.print("Masukkan umur\t:\s");
        int age = scanner.nextInt();

        System.out.println("Nama\t:\s"+ name);
        System.out.println("Umur\t:\s"+ age);
    }
}
