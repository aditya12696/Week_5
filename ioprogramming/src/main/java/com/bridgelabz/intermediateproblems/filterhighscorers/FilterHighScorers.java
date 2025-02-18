package com.bridgelabz.intermediateproblems.filterhighscorers;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class FilterHighScorers {
    public static void main(String[] args) {
        String filePath = "D:\\Capg\\Week_5\\ioprogramming\\src\\student.csv"; // Change this to your CSV file path

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            reader.readNext(); // Skip the header row

            System.out.println("Students who scored more than 80 marks:");
            while ((nextLine = reader.readNext()) != null) {
                int marks = Integer.parseInt(nextLine[3]); // Assuming marks are in the 4th column (index 3)
                if (marks > 80) {
                    System.out.println("Student ID: " + nextLine[0] + ", Name: " + nextLine[1] + ", Marks: " + marks);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
