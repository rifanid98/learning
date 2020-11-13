package com.java02_oop.oop2_programmer_zaman_now.lesson07_equals_hashcode;

public class Product {
    String name;

    Product(String name) {
        this.name = name;
    }

    /**
     * Override default equals method, to compare object
     * not by memory location.
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return name != null ? name.equals(product.name) : product.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
