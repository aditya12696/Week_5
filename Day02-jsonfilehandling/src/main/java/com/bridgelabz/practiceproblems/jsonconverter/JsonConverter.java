package com.bridgelabz.practiceproblems.jsonconverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class to convert a list of Java objects into a JSON array.
 */
public class JsonConverter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Converts a list of Student objects into a JSON array string.
     *
     * @param students List of students.
     * @return JSON array as a string.
     * @throws JsonProcessingException if conversion fails.
     */
    public static String convertListToJson(List<Student> students) throws JsonProcessingException {
        return objectMapper.writeValueAsString(students);
    }

    public static void main(String[] args) {
        try {
            // Create a list of Student objects
            List<Student> students = Arrays.asList(
                    new Student("Alice", 22, new String[]{"Math", "Physics"}),
                    new Student("Bob", 21, new String[]{"Chemistry", "Biology"})
            );

            // Convert the list to JSON
            String jsonArray = convertListToJson(students);

            // Print JSON array
            System.out.println(jsonArray);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

