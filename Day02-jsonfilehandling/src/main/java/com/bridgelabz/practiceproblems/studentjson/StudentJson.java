package com.bridgelabz.practiceproblems.studentjson;
import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJson {
    public static JSONObject createStudentJson(String name, int age, String[] subjects) {
        JSONObject student = new JSONObject();
        student.put("name", name);
        student.put("age", age);
        student.put("subjects", new JSONArray(subjects));
        return student;
    }

    public static void main(String[] args) {
        String[] subjects = {"Math", "Science", "History"};
        JSONObject studentJson = createStudentJson("John Doe", 20, subjects);
        System.out.println(studentJson.toString(2)); // Pretty print JSON
    }
}
