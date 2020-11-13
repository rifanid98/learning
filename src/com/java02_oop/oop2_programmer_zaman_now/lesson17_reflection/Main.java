package com.java02_oop.oop2_programmer_zaman_now.lesson17_reflection;

public class Main {

    public static void main(String[] args) {
        CreateUserRequest createUserRequest = new CreateUserRequest();

        ValidationUtil.validationReflection(createUserRequest);
    }
}
