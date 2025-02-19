package com.bridgelabz.hands_on.mergejsonfilestest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MergeJsonFilesTest {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private JsonNode jsonNode1;
    private JsonNode jsonNode2;

    @BeforeEach
    void setup() throws IOException {
        // Load test JSON files
        jsonNode1 = objectMapper.readTree(new File("D:\\local\\Week_5\\Day02-jsonfilehandling\\src\\main\\resources\\file1.json"));
        jsonNode2 = objectMapper.readTree(new File("D:\\local\\Week_5\\Day02-jsonfilehandling\\src\\main\\resources\\file2.json"));
    }

    @Test
    void testMergeJsonFiles() {
        // Merge JSON objects
        ObjectNode mergedJson = objectMapper.createObjectNode();
        mergedJson.setAll((ObjectNode) jsonNode1);
        mergedJson.setAll((ObjectNode) jsonNode2);

        // Check if merged JSON contains expected fields
        assertTrue(mergedJson.has("name"));
        assertTrue(mergedJson.has("age"));
        assertTrue(mergedJson.has("email"));
        assertTrue(mergedJson.has("city"));

        // Verify values
        assertEquals("John Doe", mergedJson.get("name").asText());
        assertEquals(30, mergedJson.get("age").asInt());
        assertEquals("john.doe@example.com", mergedJson.get("email").asText());
        assertEquals("New York", mergedJson.get("city").asText());
    }
}
