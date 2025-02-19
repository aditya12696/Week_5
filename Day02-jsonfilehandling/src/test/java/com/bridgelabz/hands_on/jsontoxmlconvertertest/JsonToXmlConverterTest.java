package com.bridgelabz.hands_on.jsontoxmlconvertertest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonToXmlConverterTest {
    @Test
    void testJsonToXmlConversion() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        // Read JSON file
        JsonNode jsonNode = objectMapper.readTree(new File("D:\\local\\Week_5\\Day02-jsonfilehandling\\src\\main\\resources\\data.json"));

        // Convert to XML
        String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        // Validate XML contains expected elements
        assertTrue(xml.contains("<name>John Doe</name>"));
        assertTrue(xml.contains("<age>30</age>"));
        assertTrue(xml.contains("<email>john.doe@example.com</email>"));
    }
}
