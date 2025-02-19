package com.bridgelabz.hands_on.jsonconverter;

/**
 * Person class representing a Java object.
 */
public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters required for Jackson serialization
    public String getName() { return name; }
    public int getAge() { return age; }
}
