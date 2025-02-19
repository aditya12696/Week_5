package com.bridgelabz.hands_on.mergejsonfiles;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class MergeJsonFiles {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Read both JSON files
            JsonNode jsonNode1 = objectMapper.readTree(new File("D:\\local\\Week_5\\Day02-jsonfilehandling\\src\\main\\resources\\file1.json"));
            JsonNode jsonNode2 = objectMapper.readTree(new File("D:\\local\\Week_5\\Day02-jsonfilehandling\\src\\main\\resources\\file2.json"));

            // Merge JSON objects
            ObjectNode mergedJson = objectMapper.createObjectNode();
            mergedJson.setAll((ObjectNode) jsonNode1);
            mergedJson.setAll((ObjectNode) jsonNode2);

            // Print merged JSON
            System.out.println("Merged JSON: " + mergedJson.toPrettyString());

            // Save to a new file
            objectMapper.writeValue(new File("merged.json"), mergedJson);
            System.out.println("Merged JSON saved to merged.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
