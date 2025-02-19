package com.bridgelabz.hands_on.jsonschemavalidator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

import java.io.File;
import java.util.Set;

public class JsonSchemaValidator {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String validateJson(String jsonFilePath, String schemaFilePath) throws Exception {
        JsonNode jsonNode = objectMapper.readTree(new File(jsonFilePath));
        JsonNode schemaNode = objectMapper.readTree(new File(schemaFilePath));

        // Explicitly specify Draft-07 schema version
        JsonSchema schema = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7).getSchema(schemaNode);
        Set<ValidationMessage> validationMessages = schema.validate(jsonNode);

        if (validationMessages.isEmpty()) {
            return "JSON is valid!";
        } else {
            return "JSON validation errors: " + validationMessages;
        }
    }

    public static void main(String[] args) {
        try {
            String jsonFilePath = "D:\\local\\Week_5\\Day02-jsonfilehandling\\src\\main\\resources\\data.json";
            String schemaFilePath = "D:\\local\\Week_5\\Day02-jsonfilehandling\\src\\main\\resources\\schema.json";

            String result = validateJson(jsonFilePath, schemaFilePath);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
