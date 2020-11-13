package com.java02_oop.oop2_programmer_zaman_now.lesson13_exception.error_exception;

public class Main {

    public static void main(String[] args) {
        connectDB("Adnin", "");
        System.out.println("Koneksi ke database berhasil");
    }

    public static void connectDB(String username, String password) {
        if (username == null || password == null || username.isBlank() || password.isBlank()) {
            throw new DatabaseError("Tidak bisa terhubung ke database");
        }
    }
}
