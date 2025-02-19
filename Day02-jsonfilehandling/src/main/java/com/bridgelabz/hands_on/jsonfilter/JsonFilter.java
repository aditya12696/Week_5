package com.bridgelabz.hands_on.jsonfilter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for filtering JSON data based on age.
 */
public class JsonFilter {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Filters JSON records where age > 25.
     *
     * @param filePath Path to the JSON file.
     * @return Filtered JSON array as a string.
     * @throws Exception if JSON processing fails.
     */
    public static String filterUsersByAge(String filePath) throws Exception {
        JsonNode rootNode = objectMapper.readTree(new File(filePath));
        List<JsonNode> filteredUsers = new ArrayList<>();

        for (JsonNode user : rootNode) {
            if (user.has("age") && user.get("age").asInt() > 25) {
                filteredUsers.add(user);
            }
        }

        return objectMapper.writeValueAsString(filteredUsers);
    }

    public static void main(String[] args) {
        try {
            String filePath = "D:\\local\\Week_5\\Day02-jsonfilehandling\\src\\main\\resources\\users.json"; // Path to JSON file
            String filteredJson = filterUsersByAge(filePath);
            System.out.println(filteredJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
