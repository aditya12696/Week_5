package com.bridgelabz.advancedproblems.convertcsvdatajavaobjects;
public class Student {
    private String id;
    private String name;
    private int age;
    private int marks;
    private String grade;

    // Constructor
    public Student(String id, String name, int age, int marks, String grade) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
        this.grade = grade;
    }

    // Override toString() for easy printing
    @Override
    public String toString() {
        return "Student{ ID=" + id + ", Name=" + name + ", Age=" + age +
                ", Marks=" + marks + ", Grade=" + grade + " }";
    }
}
