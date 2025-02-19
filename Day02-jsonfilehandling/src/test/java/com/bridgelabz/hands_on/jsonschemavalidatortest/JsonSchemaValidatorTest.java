package com.bridgelabz.hands_on.jsonschemavalidatortest;
import static org.junit.jupiter.api.Assertions.*;

import com.bridgelabz.hands_on.jsonschemavalidator.JsonSchemaValidator;
import org.junit.jupiter.api.Test;
import java.io.FileWriter;
import java.io.File;

/**
 * Unit test for JsonSchemaValidator class.
 */
public class JsonSchemaValidatorTest {

    private static final String TEST_JSON_FILE = "test_data.json";
    private static final String SCHEMA_FILE = "schema.json";

    /**
     * Test valid JSON against schema.
     */
    @Test
    void testValidJson() throws Exception {
        // Create a valid JSON file
        String validJson = "{ \"name\": \"Alice\", \"email\": \"alice@example.com\" }";
        try (FileWriter fileWriter = new FileWriter(TEST_JSON_FILE)) {
            fileWriter.write(validJson);
        }

        // Validate JSON
        String result = JsonSchemaValidator.validateJson(TEST_JSON_FILE, SCHEMA_FILE);
        assertEquals("JSON is valid!", result, "Valid JSON should pass validation");

        // Cleanup test file
        new File(TEST_JSON_FILE).delete();
    }

    /**
     * Test invalid JSON against schema.
     */
    @Test
    void testInvalidJson() throws Exception {
        // Create an invalid JSON file
        String invalidJson = "{ \"name\": \"Alice\", \"email\": \"alice_at_example.com\" }";
        try (FileWriter fileWriter = new FileWriter(TEST_JSON_FILE)) {
            fileWriter.write(invalidJson);
        }

        // Validate JSON
        String result = JsonSchemaValidator.validateJson(TEST_JSON_FILE, SCHEMA_FILE);
        assertTrue(result.contains("JSON validation errors"), "Invalid JSON should fail validation");

        // Cleanup test file
        new File(TEST_JSON_FILE).delete();
    }
}
