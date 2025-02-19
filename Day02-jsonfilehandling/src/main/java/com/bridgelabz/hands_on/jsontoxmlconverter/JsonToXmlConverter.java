package com.bridgelabz.hands_on.jsontoxmlconverter;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class JsonToXmlConverter {
    public static void main(String[] args) {
        try {
            // Initialize ObjectMapper for JSON and XmlMapper for XML
            ObjectMapper objectMapper = new ObjectMapper();
            XmlMapper xmlMapper = new XmlMapper();

            // Read JSON file
            JsonNode jsonNode = objectMapper.readTree(new File("D:\\local\\Week_5\\Day02-jsonfilehandling\\src\\main\\resources\\data.json"));

            // Convert JSON to XML
            String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

            // Print XML output
            System.out.println("Converted XML:\n" + xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
