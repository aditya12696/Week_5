package com.bridgelabz.advancedproblems.readlargecsv;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "D:\\Capg\\Week_5\\ioprogramming\\src\\large_file.csv"; // Change this to your CSV file path
        int batchSize = 100; // Number of lines to process at a time
        int recordCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header row if present

            while ((line = br.readLine()) != null) {
                // Process the line (example: just count it here)
                recordCount++;

                if (recordCount % batchSize == 0) {
                    System.out.println("Processed " + recordCount + " records...");
                }
            }

            System.out.println("Total records processed: " + recordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
