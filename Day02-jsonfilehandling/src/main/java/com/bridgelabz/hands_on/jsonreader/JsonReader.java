package com.bridgelabz.hands_on.jsonreader;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

/**
 * Utility class for reading a JSON file and printing all keys and values.
 */
public class JsonReader {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Reads a JSON file and prints all keys and values.
     *
     * @param filePath Path to the JSON file.
     * @throws Exception if file reading fails.
     */
    public static void readAndPrintJson(String filePath) throws Exception {
        JsonNode rootNode = objectMapper.readTree(new File(filePath));
        printJson(rootNode, "");
    }

    /**
     * Recursively prints keys and values from a JSON node.
     *
     * @param node  The current JSON node.
     * @param keyPrefix Prefix for nested keys.
     */
    private static void printJson(JsonNode node, String keyPrefix) {
        if (node.isObject()) {
            for (Iterator<Map.Entry<String, JsonNode>> it = node.fields(); it.hasNext(); ) {
                Map.Entry<String, JsonNode> entry = it.next();
                printJson(entry.getValue(), keyPrefix + entry.getKey() + ".");
            }
        } else if (node.isArray()) {
            for (int i = 0; i < node.size(); i++) {
                printJson(node.get(i), keyPrefix + "[" + i + "].");
            }
        } else {
            System.out.println(keyPrefix.substring(0, keyPrefix.length() - 1) + " : " + node.asText());
        }
    }

    public static void main(String[] args) {
        try {
            String filePath = "D:\\local\\Week_5\\Day02-jsonfilehandling\\src\\main\\resources\\data1.json"; // Path to JSON file
            readAndPrintJson(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
