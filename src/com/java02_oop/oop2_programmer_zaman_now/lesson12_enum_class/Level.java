package com.java02_oop.oop2_programmer_zaman_now.lesson12_enum_class;

/**
 * ENUM Class
 *
 * dipakai untuk membuat semacam pilihan
 */
public enum Level {
    STANDARD("standard level"),
    PREMIUM("premium level"),
    VIP("vip level");

    private String description;

    /** ENUM Constructor */
    Level(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
