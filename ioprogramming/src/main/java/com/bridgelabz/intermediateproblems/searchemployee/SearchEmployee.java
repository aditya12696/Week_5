package com.bridgelabz.intermediateproblems.searchemployee;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchEmployee {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // Change this to your CSV file path
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee name to search: ");
        String searchName = scanner.nextLine().trim();
        scanner.close();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            reader.readNext(); // Skip the header row

            boolean found = false;
            while ((nextLine = reader.readNext()) != null) {
                if (nextLine[1].equalsIgnoreCase(searchName)) { // Comparing names (Column index 1)
                    System.out.println("Employee Found!");
                    System.out.println("Department: " + nextLine[2]);
                    System.out.println("Salary: " + nextLine[3]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
