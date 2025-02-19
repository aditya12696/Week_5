package com.bridgelabz.practiceproblems.jsonfilter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for parsing JSON and filtering records based on age.
 */
public class JsonFilter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Filters JSON records where age > 25.
     *
     * @param jsonArray JSON array string.
     * @return Filtered JSON array as a string.
     * @throws Exception if JSON processing fails.
     */
    public static String filterByAge(String jsonArray) throws Exception {
        JsonNode rootNode = objectMapper.readTree(jsonArray);
        List<JsonNode> filteredList = new ArrayList<>();

        for (JsonNode node : rootNode) {
            if (node.has("age") && node.get("age").asInt() > 25) {
                filteredList.add(node);
            }
        }

        return objectMapper.writeValueAsString(filteredList);
    }

    public static void main(String[] args) {
        try {
            // Sample JSON array
            String jsonArray = "[{\"name\": \"Alice\", \"age\": 22},"
                    + "{\"name\": \"Bob\", \"age\": 30},"
                    + "{\"name\": \"Charlie\", \"age\": 28}]";

            // Filter records where age > 25
            String filteredJson = filterByAge(jsonArray);

            // Print the filtered JSON
            System.out.println(filteredJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
