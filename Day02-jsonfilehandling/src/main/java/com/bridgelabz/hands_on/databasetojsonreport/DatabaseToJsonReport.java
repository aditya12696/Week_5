package com.bridgelabz.hands_on.databasetojsonreport;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class DatabaseToJsonReport {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb"; // Change as needed
        String user = "root";
        String password = "password";

        // Initialize Jackson ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode studentsArray = objectMapper.createArrayNode();

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

            // Process ResultSet and convert to JSON
            while (rs.next()) {
                ObjectNode student = objectMapper.createObjectNode();
                student.put("id", rs.getInt("id"));
                student.put("name", rs.getString("name"));
                student.put("age", rs.getInt("age"));
                student.put("email", rs.getString("email"));
                studentsArray.add(student);
            }

            // Save JSON to file
            File jsonFile = new File("students_report.json");
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(jsonFile, studentsArray);

            System.out.println("JSON report generated: " + jsonFile.getAbsolutePath());

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
