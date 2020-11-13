package com.java02_oop.oop2_programmer_zaman_now.lesson13_exception.checked_exception;

import com.java02_oop.oop2_programmer_zaman_now.lesson11_record_class.LoginRequest;

public class ValidationUtil {

    public static void validate(LoginRequest loginRequest) throws ValidationException, NullPointerException {
         if (loginRequest.username() == null) {
             throw new NullPointerException("Username tidak boleh null");
         } else if (loginRequest.username().isBlank()) {
             throw new ValidationException("Username tidak boleh kosong");
         }

         if (loginRequest.password() == null) {
             throw new NullPointerException("Username tidak boleh null");
         } else if (loginRequest.password().isBlank()) {
             throw new ValidationException("Username tidak boleh kosong");
         }
    }
}
