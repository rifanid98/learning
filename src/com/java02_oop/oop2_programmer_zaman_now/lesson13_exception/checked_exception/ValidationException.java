package com.java02_oop.oop2_programmer_zaman_now.lesson13_exception.checked_exception;

/**
 * Custom Exception
 *
 * membuat exception sendiri
 */
public class ValidationException extends Throwable {

    ValidationException(String message) {
        super(message);
    }
}
