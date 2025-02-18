package com.bridgelabz.advancedproblems.detectduplicatescsv;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DetectDuplicatesCSV {
    public static void main(String[] args) {
        String filePath = "D:\\Capg\\Week_5\\ioprogramming\\src\\student.csv"; // Change to your CSV file
        Map<String, String[]> recordMap = new HashMap<>();
        Set<String> duplicates = new HashSet<>();

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext(); // Read header
            String[] nextLine;

            while ((nextLine = reader.readNext()) != null) {
                String id = nextLine[0]; // Assuming ID is the first column
                if (recordMap.containsKey(id)) {
                    duplicates.add(id); // Mark duplicate
                } else {
                    recordMap.put(id, nextLine);
                }
            }

            // Print duplicate records
            if (duplicates.isEmpty()) {
                System.out.println("No duplicate records found.");
            } else {
                System.out.println("Duplicate Records:");
                for (String dupID : duplicates) {
                    System.out.println(String.join(", ", recordMap.get(dupID)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
