package com.java02_oop2.lesson11_record_class;

public class Main {

    public static void main(String[] args) {
        LoginRequest loginRequest = new LoginRequest("username", "password");
        System.out.println(loginRequest.toString());
    }
}
