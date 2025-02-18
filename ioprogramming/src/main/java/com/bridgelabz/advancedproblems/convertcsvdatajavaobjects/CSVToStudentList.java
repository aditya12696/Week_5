package com.bridgelabz.advancedproblems.convertcsvdatajavaobjects;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVToStudentList {
    public static void main(String[] args) {
        String filePath = "D:\\Capg\\Week_5\\ioprogramming\\src\\student.csv"; // Change this to your CSV file path
        List<Student> students = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            reader.readNext(); // Skip the header row
            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {
                // Convert CSV row data into Student object
                Student student = new Student(
                        nextLine[0],  // ID
                        nextLine[1],  // Name
                        Integer.parseInt(nextLine[2]), // Age
                        Integer.parseInt(nextLine[3]), // Marks
                        nextLine[4]   // Grade
                );
                students.add(student); // Add student to the list
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

        // Print all student objects
        System.out.println("Students List:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
