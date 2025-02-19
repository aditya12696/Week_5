package com.bridgelabz.practiceproblems.jsonconverter;

/**
 * Student class representing a Java object.
 */
public class Student {
    private String name;
    private int age;
    private String[] subjects;

    public Student(String name, int age, String[] subjects) {
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }

    // Getters required for Jackson serialization
    public String getName() { return name; }
    public int getAge() { return age; }
    public String[] getSubjects() { return subjects; }
}
