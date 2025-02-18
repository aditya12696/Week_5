package com.bridgelabz.advancedproblems.jsontocsvconverter;
import org.json.JSONArray;
import org.json.JSONObject;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonToCsvConverter {
    public static void main(String[] args) {
        String jsonFile = "src/main/students.json";
        String csvFile = "students.csv";

        try (FileReader reader = new FileReader(jsonFile)) {
            // Read JSON data
            char[] buffer = new char[1024];
            int len = reader.read(buffer);
            String jsonString = new String(buffer, 0, len);

            JSONArray jsonArray = new JSONArray(jsonString);
            List<String[]> data = new ArrayList<>();

            // Add headers
            JSONObject firstObject = jsonArray.getJSONObject(0);
            data.add(firstObject.keySet().toArray(new String[0]));

            // Add records
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                data.add(new String[]{String.valueOf(obj.getInt("ID")), obj.getString("Name"),
                        String.valueOf(obj.getInt("Age")), String.valueOf(obj.getInt("Marks")),
                        obj.getString("Grade")});
            }

            // Write CSV file
            try (CSVWriter writer = new CSVWriter(new FileWriter(csvFile))) {
                writer.writeAll(data);
            }

            System.out.println("JSON converted to CSV successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
