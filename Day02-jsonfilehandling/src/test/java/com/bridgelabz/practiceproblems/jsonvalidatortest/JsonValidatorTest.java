package com.bridgelabz.practiceproblems.jsonvalidatortest;
import static org.junit.jupiter.api.Assertions.*;

import com.bridgelabz.practiceproblems.jsonvalidator.JsonValidator;
import org.junit.jupiter.api.Test;

/**
 * Unit test for JsonValidator class.
 */
public class JsonValidatorTest {

    /**
     * Test to verify JSON validation.
     */
    @Test
    void testValidJson() {
        String validJson = "{ \"name\": \"Alice\", \"email\": \"alice@example.com\", \"age\": 25 }";
        assertTrue(JsonValidator.isValidJson(validJson), "Valid JSON should pass validation");
    }

    /**
     * Test to verify invalid JSON detection.
     */
    @Test
    void testInvalidJson() {
        String invalidJson = "{ \"name\": \"Alice\", \"email\": \"alice@example.com\", \"age\": 25 "; // Missing brace
        assertFalse(JsonValidator.isValidJson(invalidJson), "Invalid JSON should fail validation");
    }
}
