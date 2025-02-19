package com.bridgelabz.hands_on.jsonconverter;
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
     * Converts a list of Person objects into a JSON array string.
     *
     * @param people List of Person objects.
     * @return JSON array as a string.
     * @throws JsonProcessingException if conversion fails.
     */
    public static String convertListToJson(List<Person> people) throws JsonProcessingException {
        return objectMapper.writeValueAsString(people);
    }

    public static void main(String[] args) {
        try {
            // Create a list of Person objects
            List<Person> people = Arrays.asList(
                    new Person("Alice", 25),
                    new Person("Bob", 30)
            );

            // Convert the list to JSON
            String jsonArray = convertListToJson(people);

            // Print JSON array
            System.out.println(jsonArray);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

