package com.bridgelabz.advancedproblems.validatecsvdata;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ValidateCSVData {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // Change this to your CSV file path

        // Regular expression for a valid email format
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        // Regular expression for a 10-digit phone number
        String phoneRegex = "^[0-9]{10}$";
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (CSVReader reader = new CSVReader(new FileReader("D:\\Capg\\Week_5\\ioprogramming\\src\\employee.csv"))) {
            String[] header = reader.readNext(); // Read and store the header row
            String[] nextLine;
            int rowNumber = 1; // Track row numbers for error messages

            while ((nextLine = reader.readNext()) != null) {
                rowNumber++;

                String email = nextLine[4]; // Assuming email is in the 5th column (index 4)
                String phone = nextLine[5]; // Assuming phone number is in the 6th column (index 5)

                boolean validEmail = emailPattern.matcher(email).matches();
                boolean validPhone = phonePattern.matcher(phone).matches();

                // Print error messages for invalid data
                if (!validEmail || !validPhone) {
                    System.out.println("Invalid data found in row " + rowNumber + ": " + String.join(", ", nextLine));

                    if (!validEmail) {
                        System.out.println("Invalid Email: " + email);
                    }
                    if (!validPhone) {
                        System.out.println("Invalid Phone Number: " + phone);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
