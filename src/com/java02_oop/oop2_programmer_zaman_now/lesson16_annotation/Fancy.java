package com.java02_oop.oop2_programmer_zaman_now.lesson16_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Hanya bisa digunakan di TYPE (class, interface, type).
 * karena isi @Target nya adalah ElementType.TYPE, coba
 * ganti TYPE menjadi METHOD, atau tambahkan (dipisahkan
 * dengan koma) maka bisa digunakan di method, dan TYPE juga
 */
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Fancy {
    String name();
    String[] tags() default {};
}
