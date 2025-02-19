package com.bridgelabz.practiceproblems.jsonfiltertest;
import static org.junit.jupiter.api.Assertions.*;

import com.bridgelabz.practiceproblems.jsonfilter.JsonFilter;
import org.junit.jupiter.api.Test;

/**
 * Unit test for JsonFilter class.
 */
public class JsonFilterTest {

    /**
     * Test to verify filtering of records where age > 25.
     */
    @Test
    void testFilterByAge() throws Exception {
        String inputJson = "[{\"name\": \"Alice\", \"age\": 22},"
                + "{\"name\": \"Bob\", \"age\": 30},"
                + "{\"name\": \"Charlie\", \"age\": 28}]";

        String expectedJson = "[{\"name\":\"Bob\",\"age\":30},{\"name\":\"Charlie\",\"age\":28}]";

        String actualJson = JsonFilter.filterByAge(inputJson);

        assertEquals(expectedJson, actualJson, "Filtered JSON output does not match expected output");
    }
}
