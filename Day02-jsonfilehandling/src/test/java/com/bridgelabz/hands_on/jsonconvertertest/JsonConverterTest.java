package com.bridgelabz.hands_on.jsonconvertertest;

import static org.junit.jupiter.api.Assertions.*;

import com.bridgelabz.hands_on.jsonconverter.JsonConverter;
import com.bridgelabz.hands_on.jsonconverter.Person;
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
        // Sample person list
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30)
        );

        // Expected JSON output
        String expectedJson = "[{\"name\":\"Alice\",\"age\":25},{\"name\":\"Bob\",\"age\":30}]";

        // Convert list to JSON
        String actualJson = JsonConverter.convertListToJson(people);

        // Verify JSON output
        assertEquals(expectedJson, actualJson, "JSON output does not match expected format");
    }
}
