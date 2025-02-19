package com.bridgelabz.practiceproblems.jsonmergertest;
import static org.junit.jupiter.api.Assertions.*;

import com.bridgelabz.practiceproblems.jsonmerger.JsonMerger;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

/**
 * Unit test for JsonMerger class.
 */
public class JsonMergerTest {

    /**
     * Test to verify that two JSON objects are correctly merged.
     */
    @Test
    void testMergeJsonObjects() {
        // First JSON object
        JSONObject json1 = new JSONObject();
        json1.put("name", "Alice");
        json1.put("email", "alice@example.com");

        // Second JSON object
        JSONObject json2 = new JSONObject();
        json2.put("age", 25);
        json2.put("city", "New York");

        // Expected merged JSON object
        JSONObject expectedJson = new JSONObject();
        expectedJson.put("name", "Alice");
        expectedJson.put("email", "alice@example.com");
        expectedJson.put("age", 25);
        expectedJson.put("city", "New York");

        // Perform merge
        JSONObject mergedJson = JsonMerger.mergeJsonObjects(json1, json2);

        // Verify merged JSON
        assertEquals(expectedJson.toString(), mergedJson.toString(), "Merged JSON does not match expected output");
    }
}
