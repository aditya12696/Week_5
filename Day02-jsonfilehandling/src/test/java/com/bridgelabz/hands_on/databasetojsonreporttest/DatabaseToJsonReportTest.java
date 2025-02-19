package com.bridgelabz.hands_on.databasetojsonreporttest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseToJsonReportTest {
    @Test
    void testJsonFileExists() {
        File jsonFile = new File("students_report.json");
        assertTrue(jsonFile.exists());
    }

    @Test
    void testJsonFileNotEmpty() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("students_report.json"));
        assertTrue(jsonNode.isArray() && jsonNode.size() > 0);
    }
}
