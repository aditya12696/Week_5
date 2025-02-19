package com.bridgelabz.practiceproblems.jsonreadertest;
import static org.junit.jupiter.api.Assertions.*;

import com.bridgelabz.practiceproblems.jsonreader.JsonReader;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Unit test for JsonReader class.
 */
public class JsonReaderTest {

    /**
     * Test to verify the extraction of specific fields (name and email).
     */
    @Test
    void testExtractFields() throws Exception {
        // Sample JSON content
        String jsonContent = "{ \"name\": \"Alice\", \"email\": \"alice@example.com\", \"age\": 25 }";

        // Temporary file to simulate reading from a JSON file
        String tempFilePath = "test.json";
        Files.write(Paths.get(tempFilePath), jsonContent.getBytes());

        // Extract fields from the test JSON file
        JSONObject extractedJson = JsonReader.extractFields(tempFilePath);

        // Assertions to verify extracted values
        assertEquals("Alice", extractedJson.getString("name"), "Name does not match");
        assertEquals("alice@example.com", extractedJson.getString("email"), "Email does not match");

        // Cleanup: Delete the temporary test file
        Files.delete(Paths.get(tempFilePath));
    }
}
