package com.bridgelabz.practiceproblems.jsonvalidator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility class for JSON validation using Jackson.
 */
public class JsonValidator {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Validates if the given JSON string is well-formed.
     *
     * @param jsonString The JSON string to validate.
     * @return true if valid, false otherwise.
     */
    public static boolean isValidJson(String jsonString) {
        try {
            // Parse JSON string to check validity
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            return jsonNode != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Example valid JSON string
        String validJson = "{ \"name\": \"Alice\", \"email\": \"alice@example.com\", \"age\": 25 }";
        System.out.println("Valid JSON? " + isValidJson(validJson));

        // Example invalid JSON string
        String invalidJson = "{ \"name\": \"Alice\", \"email\": \"alice@example.com\", \"age\": 25 "; // Missing closing brace
        System.out.println("Valid JSON? " + isValidJson(invalidJson));
    }
}
