package com.github.curriculeon;

public class Person {
    private final long id;
    private String name;

    public Person() {
        this.id = System.nanoTime();
    }

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
