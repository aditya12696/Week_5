package com.bridgelabz.intermediateproblems.sortemployeesbysalary;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortEmployeesBySalary {
    public static void main(String[] args) {
        String filePath = "D:\\Capg\\Week_5\\ioprogramming\\src\\employee.csv"; // Change this to your CSV file path
        List<String[]> employeeData = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext(); // Read the header row
            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {
                employeeData.add(nextLine);
            }

            // Sorting by salary in descending order (Column index 3)
            employeeData.sort(Comparator.comparingDouble(o -> -Double.parseDouble(o[3])));

            // Print the top 5 highest-paid employees
            System.out.println("Top 5 Highest-Paid Employees:");
            System.out.println("ID | Name | Department | Salary");
            for (int i = 0; i < Math.min(5, employeeData.size()); i++) {
                String[] employee = employeeData.get(i);
                System.out.println(employee[0] + " | " + employee[1] + " | " + employee[2] + " | " + employee[3]);
            }

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
