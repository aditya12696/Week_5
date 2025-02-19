package com.bridgelabz.practiceproblems.car;
import static org.junit.jupiter.api.Assertions.*;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

/**
 * Unit test for the Car class to verify JSON conversion.
 */
public class CarTest {

    /**
     * Test to verify that a Car object is correctly converted into JSON format.
     */
    @Test
    void testCarToJson() {
        // Create a Car object
        Car car = new Car("Tesla", "Model S", 2022);

        // Convert it to JSON
        JSONObject carJson = car.toJson();

        // Assertions to check if JSON contains the expected values
        assertEquals("Tesla", carJson.getString("brand"), "Brand does not match");
        assertEquals("Model S", carJson.getString("model"), "Model does not match");
        assertEquals(2022, carJson.getInt("year"), "Year does not match");
    }
}

