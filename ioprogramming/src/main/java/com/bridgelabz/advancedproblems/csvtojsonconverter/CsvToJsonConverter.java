package com.bridgelabz.advancedproblems.csvtojsonconverter;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CsvToJsonConverter {
    public static void main(String[] args) {
        String csvFile = "D:\\Capg\\Week_5\\ioprogramming\\src\\student.csv";
        String jsonFile = "students_converted.json";

        try (CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] headers = reader.readNext(); // Read header row
            JSONArray jsonArray = new JSONArray();

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                JSONObject obj = new JSONObject();
                for (int i = 0; i < headers.length; i++) {
                    obj.put(headers[i], nextLine[i]);
                }
                jsonArray.put(obj);
            }

            // Write JSON file
            try (FileWriter file = new FileWriter(jsonFile)) {
                file.write(jsonArray.toString(4)); // Pretty print JSON
            }

            System.out.println("CSV converted back to JSON successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
