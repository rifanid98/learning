package com.java04_generic.lesson05_contravariant;

public class MyData<T> {
    private T value;

    public MyData(T value) {
        this.value = value;
    }

    public T getData() {
        return value;
    }

    public void setData(T value) {
        this.value = value;
    }
}
