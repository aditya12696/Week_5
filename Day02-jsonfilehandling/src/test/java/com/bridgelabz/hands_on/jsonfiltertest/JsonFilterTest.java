package com.bridgelabz.hands_on.jsonfiltertest;
import static org.junit.jupiter.api.Assertions.*;

import com.bridgelabz.hands_on.jsonfilter.JsonFilter;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;

/**
 * Unit test for JsonFilter class.
 */
public class JsonFilterTest {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String TEST_FILE = "test_users.json";

    /**
     * Test to verify filtering of records where age > 25.
     */
    @Test
    void testFilterUsersByAge() throws Exception {
        // Create a test JSON file
        String jsonContent = "[{\"name\": \"Alice\", \"age\": 22},"
                + "{\"name\": \"Bob\", \"age\": 30},"
                + "{\"name\": \"Charlie\", \"age\": 28}]";

        try (FileWriter fileWriter = new FileWriter(TEST_FILE)) {
            fileWriter.write(jsonContent);
        }

        // Read and filter the JSON data
        String filteredJson = JsonFilter.filterUsersByAge(TEST_FILE);

        // Expected JSON output
        String expectedJson = "[{\"name\":\"Bob\",\"age\":30},{\"name\":\"Charlie\",\"age\":28}]";

        // Verify JSON output
        assertEquals(expectedJson, filteredJson, "Filtered JSON output does not match expected output");

        // Cleanup test file
        new File(TEST_FILE).delete();
    }
}
