package com.java04_generic.lesson06_bounded_type_parameter;

public class NumberData<T extends Number> {
    private T value;

    public NumberData(T value) {
        this.value = value;
    }

    public T getData() {
        return value;
    }

    public void setData(T value) {
        this.value = value;
    }
}
