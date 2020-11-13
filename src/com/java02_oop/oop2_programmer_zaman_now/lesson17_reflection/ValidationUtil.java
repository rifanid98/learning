package com.java02_oop.oop2_programmer_zaman_now.lesson17_reflection;


import com.java02_oop.oop2_programmer_zaman_now.lesson13_exception.runtime_exception.BlankException;

import java.lang.reflect.Field;

public class ValidationUtil {

    public static void validationReflection(Object object) {
        Class aClass = object.getClass();
        Field[] fields = aClass.getDeclaredFields();

        String errors = "";
        for (var field: fields ) {
            field.setAccessible(true);
            if (field.getAnnotation(NotBlank.class) != null) {
                try {
                    String value = (String) field.get(object);
                    if (value == null || value.isBlank()) {
                        errors += "\nField " + field.getName() + " is blank";
                    }
                } catch (IllegalAccessException exception) {
                    System.out.println("Tidak bisa mengakses field " + field.getName());
                }
            }
        }
        if (errors.length() > 0) {
            throw new BlankException(errors);
        }
    }
}
