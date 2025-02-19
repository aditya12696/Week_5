package com.bridgelabz.practiceproblems.studentjsontest;
import static org.junit.jupiter.api.Assertions.*;

import com.bridgelabz.practiceproblems.studentjson.StudentJson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class StudentJsonTest {

    @Test
    void testCreateStudentJson() {
        String[] subjects = {"Math", "Science", "History"};
        JSONObject student = StudentJson.createStudentJson("John Doe", 20, subjects);

        assertEquals("John Doe", student.getString("name"));
        assertEquals(20, student.getInt("age"));

        JSONArray subjectArray = student.getJSONArray("subjects");
        assertEquals(3, subjectArray.length());
        assertEquals("Math", subjectArray.getString(0));
        assertEquals("Science", subjectArray.getString(1));
        assertEquals("History", subjectArray.getString(2));
    }
}
