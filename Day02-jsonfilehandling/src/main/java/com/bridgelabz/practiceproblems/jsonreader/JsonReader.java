package com.bridgelabz.practiceproblems.jsonreader;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Utility class to read a JSON file and extract specific fields.
 */
public class JsonReader {

    /**
     * Reads a JSON file and extracts the "name" and "email" fields.
     *
     * @param filePath Path to the JSON file.
     * @return Extracted details as a JSONObject.
     * @throws Exception if an error occurs during file reading.
     */
    public static JSONObject extractFields(String filePath) throws Exception {
        // Read the JSON file as a string
        String content = new String(Files.readAllBytes(Paths.get(filePath)));

        // Convert the string content to a JSONObject
        JSONObject jsonObject = new JSONObject(content);

        // Create a new JSON object with only the required fields
        JSONObject extractedData = new JSONObject();
        extractedData.put("name", jsonObject.optString("name", "N/A"));
        extractedData.put("email", jsonObject.optString("email", "N/A"));

        return extractedData;
    }

    public static void main(String[] args) {
        try {
            // Example JSON file path (update with the actual path)
            String filePath = "D:\\local\\Week_5\\Day02-jsonfilehandling\\src\\main\\resources\\data.json";

            // Extract name and email from JSON file
            JSONObject extractedJson = extractFields(filePath);

            // Print the extracted JSON
            System.out.println(extractedJson.toString(2)); // Pretty print JSON
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
