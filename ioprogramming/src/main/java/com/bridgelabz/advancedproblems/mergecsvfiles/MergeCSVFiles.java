package com.bridgelabz.advancedproblems.mergecsvfiles;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "D:\\Capg\\Week_5\\ioprogramming\\src\\main\\java\\com\\bridgelabz\\advancedproblems\\mergecsvfiles\\students1.csv"; // File containing ID, Name, Age
        String file2 = "D:\\Capg\\Week_5\\ioprogramming\\src\\main\\java\\com\\bridgelabz\\advancedproblems\\mergecsvfiles\\students2.csv"; // File containing ID, Marks, Grade
        String outputFile = "merged_students.csv"; // Output file

        Map<String, String[]> studentMap = new HashMap<>();

        try (CSVReader reader1 = new CSVReader(new FileReader(file1))) {
            String[] header1 = reader1.readNext(); // Read header
            String[] nextLine;
            while ((nextLine = reader1.readNext()) != null) {
                studentMap.put(nextLine[0], nextLine); // Store data with ID as key
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

        try (CSVReader reader2 = new CSVReader(new FileReader(file2))) {
            reader2.readNext(); // Skip header row
            String[] nextLine;
            while ((nextLine = reader2.readNext()) != null) {
                String id = nextLine[0];
                if (studentMap.containsKey(id)) {
                    // Merge student data with marks and grade
                    String[] studentData = studentMap.get(id);
                    String[] mergedData = {studentData[0], studentData[1], studentData[2], nextLine[1], nextLine[2]};
                    studentMap.put(id, mergedData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

        // Write merged data to a new CSV file
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
            String[] header = {"ID", "Name", "Age", "Marks", "Grade"};
            writer.writeNext(header); // Write header

            for (String[] student : studentMap.values()) {
                writer.writeNext(student);
            }
            System.out.println("Merged CSV file created: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
