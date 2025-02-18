package com.bridgelabz.basicproblems.countcsvrows;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;

public class CountCSVRows {
    public static void main(String[] args) {
        String filePath = "D:\\Capg\\Week_5\\ioprogramming\\src\\student.csv"; // Change this to your CSV file path
        int rowCount = 0;

        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            reader.readNext(); // Skip the header row
            while (reader.readNext() != null) {
                rowCount++;
            }
            System.out.println("Total number of records: " + rowCount);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
