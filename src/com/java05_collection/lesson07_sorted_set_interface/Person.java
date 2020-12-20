package com.java05_collection.lesson07_sorted_set_interface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private List<String> hobbies;

    public Person(String name) {
        this.name = name;
        this.hobbies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addHobby(String hobby) {
        this.hobbies.add(hobby);
    }

    public List<String> getMutableHobbies() {
        return this.hobbies;
    }

    public List<String> getImmutableHobbies() {
        return Collections.unmodifiableList(this.hobbies);
    }
}
