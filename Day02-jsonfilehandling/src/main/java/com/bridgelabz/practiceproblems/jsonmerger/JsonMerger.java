package com.bridgelabz.practiceproblems.jsonmerger;
import org.json.JSONObject;

/**
 * Utility class to merge two JSON objects.
 */
public class JsonMerger {

    /**
     * Merges two JSON objects into one.
     *
     * @param json1 First JSON object.
     * @param json2 Second JSON object.
     * @return Merged JSON object.
     */
    public static JSONObject mergeJsonObjects(JSONObject json1, JSONObject json2) {
        JSONObject mergedJson = new JSONObject(json1.toString()); // Copy json1

        // Merge json2 into mergedJson
        for (String key : json2.keySet()) {
            mergedJson.put(key, json2.get(key));
        }

        return mergedJson;
    }

    public static void main(String[] args) {
        // Sample JSON objects
        JSONObject json1 = new JSONObject();
        json1.put("name", "Alice");
        json1.put("email", "alice@example.com");

        JSONObject json2 = new JSONObject();
        json2.put("age", 25);
        json2.put("city", "New York");

        // Merge JSON objects
        JSONObject mergedJson = mergeJsonObjects(json1, json2);

        // Print the merged JSON object
        System.out.println(mergedJson.toString(2)); // Pretty print JSON
    }
}
