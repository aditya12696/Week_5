package com.bridgelabz.basicproblems.readcsvfile;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;


public class ReadCsvFile {
    public static void main(String[] args) {
        try (CSVReader reader = new CSVReader(new FileReader("D:\\Capg\\Week_5\\ioprogramming\\src\\Student.csv"))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                System.out.println("Student ID: " + nextLine[0] + ", Name: " + nextLine[1] +
                        ", Age: " + nextLine[2] + ", Marks: " + nextLine[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
