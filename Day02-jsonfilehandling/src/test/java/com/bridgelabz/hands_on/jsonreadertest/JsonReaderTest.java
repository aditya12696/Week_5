package com.bridgelabz.hands_on.jsonreadertest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Unit test for JsonReader class.
 */
public class JsonReaderTest {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String TEST_FILE = "test_data.json";

    /**
     * Test to verify JSON reading and key-value extraction.
     */
    @Test
    void testReadJsonFile() throws Exception {
        // Create a test JSON file
        String jsonContent = "{ \"name\": \"Alice\", \"age\": 25, \"email\": \"alice@example.com\" }";
        try (FileWriter fileWriter = new FileWriter(TEST_FILE)) {
            fileWriter.write(jsonContent);
        }

        // Read and parse the JSON file
        JsonNode rootNode = objectMapper.readTree(new File(TEST_FILE));

        // Verify the keys and values
        assertEquals("Alice", rootNode.get("name").asText());
        assertEquals(25, rootNode.get("age").asInt());
        assertEquals("alice@example.com", rootNode.get("email").asText());

        // Cleanup test file
        new File(TEST_FILE).delete();
    }
}
