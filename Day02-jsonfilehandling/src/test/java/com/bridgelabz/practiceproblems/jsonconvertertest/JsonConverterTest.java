package com.bridgelabz.practiceproblems.jsonconvertertest;
import static org.junit.jupiter.api.Assertions.*;

import com.bridgelabz.practiceproblems.jsonconverter.JsonConverter;
import com.bridgelabz.practiceproblems.jsonconverter.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

/**
 * Unit test for JsonConverter class.
 */
public class JsonConverterTest {

    /**
     * Test to verify that a list of objects is correctly converted to a JSON array.
     */
    @Test
    void testConvertListToJson() throws JsonProcessingException {
        // Sample student list
        List<Student> students = Arrays.asList(
                new Student("Alice", 22, new String[]{"Math", "Physics"}),
                new Student("Bob", 21, new String[]{"Chemistry", "Biology"})
        );

        // Expected JSON output
        String expectedJson = "[{\"name\":\"Alice\",\"age\":22,\"subjects\":[\"Math\",\"Physics\"]},"
                + "{\"name\":\"Bob\",\"age\":21,\"subjects\":[\"Chemistry\",\"Biology\"]}]";

        // Convert list to JSON
        String actualJson = JsonConverter.convertListToJson(students);

        // Verify JSON output
        assertEquals(expectedJson, actualJson, "JSON output does not match expected format");
    }
}
