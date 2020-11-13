package com.java02_oop.oop2_programmer_zaman_now.lesson13_exception.runtime_exception;

import com.java02_oop.oop2_programmer_zaman_now.lesson11_record_class.LoginRequest;

public class Main {

    public static void main(String[] args) {
        LoginRequest loginRequest = new LoginRequest(null, null);
        ValidationUtil.validate(loginRequest);
    }
}
