package com.bridgelabz.practiceproblems.car;
import org.json.JSONObject;

/**
 * Car class representing a vehicle with brand, model, and year.
 * This class provides a method to convert its data into JSON format.
 */
public class Car {
    private String brand;
    private String model;
    private int year;

    /**
     * Constructor to initialize a Car object.
     *
     * @param brand The brand of the car.
     * @param model The model of the car.
     * @param year  The manufacturing year of the car.
     */
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    /**
     * Converts the Car object into a JSON representation.
     *
     * @return JSONObject containing car details.
     */
    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("brand", brand);
        jsonObject.put("model", model);
        jsonObject.put("year", year);
        return jsonObject;
    }

    public static void main(String[] args) {
        // Create a Car object
        Car car = new Car("Tesla", "Model S", 2022);

        // Convert the Car object to JSON
        JSONObject carJson = car.toJson();

        // Print the JSON representation of the Car object
        System.out.println(carJson.toString(2)); // Pretty print JSON with indentation
    }
}
