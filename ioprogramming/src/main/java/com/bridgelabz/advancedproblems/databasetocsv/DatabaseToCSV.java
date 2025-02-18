package com.bridgelabz.advancedproblems.databasetocsv;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class DatabaseToCSV {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/yourdatabase";
        String username = "yourusername";
        String password = "yourpassword";
        String csvFile = "employees_report.csv";

        try (Connection conn = DriverManager.getConnection(jdbcURL, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
             CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {

            // Write CSV header
            String[] header = {"Employee ID", "Name", "Department", "Salary"};
            writer.writeNext(header);

            // Write data from the database to CSV
            while (rs.next()) {
                String[] record = {
                        String.valueOf(rs.getInt("id")),
                        rs.getString("name"),
                        rs.getString("department"),
                        String.valueOf(rs.getDouble("salary"))
                };
                writer.writeNext(record);
            }

            System.out.println("CSV file created successfully: " + csvFile);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
