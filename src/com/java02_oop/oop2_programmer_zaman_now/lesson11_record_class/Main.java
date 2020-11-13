package com.java02_oop.oop2_programmer_zaman_now.lesson11_record_class;

public class Main {

    public static void main(String[] args) {
        LoginRequest loginRequest = new LoginRequest("username", "password");
        System.out.println(loginRequest.toString());
    }
}
