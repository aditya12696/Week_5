package com.bridgelabz.intermediateproblems.updateitdepartmentsalary;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateITDepartmentSalary {
    public static void main(String[] args) {
        String inputFilePath = "D:\\Capg\\Week_5\\ioprogramming\\src\\employee.csv";  // Original CSV file
        String outputFilePath = "updated_employees.csv";  // Updated CSV file

        List<String[]> allData = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(inputFilePath))) {
            String[] nextLine;
            allData.add(reader.readNext()); // Read and store the header row

            while ((nextLine = reader.readNext()) != null) {
                if (nextLine[2].equalsIgnoreCase("IT")) { // Check if department is "IT"
                    double salary = Double.parseDouble(nextLine[3]);
                    salary *= 1.10; // Increase by 10%
                    nextLine[3] = String.valueOf(salary); // Update salary
                }
                allData.add(nextLine);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

        // Writing updated data to a new CSV file
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFilePath))) {
            writer.writeAll(allData);
            System.out.println("Updated salary data saved to: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
