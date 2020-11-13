package com.java02_oop.oop1_kelas_terbuka.lesson04_object_reference;

class Book {
    String name;
    String author;
    String memoryAddress;

    Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    void display() {
        System.out.println("Book Profile");
        System.out.println("------------------------------------");
        System.out.println("Name\t\t\t: " + this.name);
        System.out.println("Author\t\t\t: " + this.author);
        System.out.println("Memory Address\t: " + this.memoryAddress);
        System.out.println();
    }

    void setMemory(String memoryAddress) {
        this.memoryAddress = memoryAddress;
    }
}

public class Main {

    public static void main(String[] args) {
        Book book1 = new Book("Conan", "Mashasi Kishimoto");
        String book1Address = Integer.toHexString(System.identityHashCode(book1));
        book1.memoryAddress = book1Address;
        book1.display();

        Book book2 = new Book("Naruto", "Pembuat Naruto");
        String book2Address = Integer.toHexString(System.identityHashCode(book2));
        book2.memoryAddress = book2Address;
        book2.display();

        Book book3 = book2;
        String book3Address = Integer.toHexString(System.identityHashCode(book3));
        book3.memoryAddress = book3Address;
        book3.display();
    }
}
