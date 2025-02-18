package com.ioprogramming.advancedproblems;



import com.ioprogramming.advancedproblems.jsoncsvconverter.JsonCsvConverter;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonCsvConverterTest {

    private final String jsonFilePath = "students.json";
    private final String csvFilePath = "students.csv";

    @Test
    public void testJsonToCsv() {
        JsonCsvConverter.jsonToCsv();
        File csvFile = new File(csvFilePath);
        assertTrue(csvFile.exists(), "CSV file was not created.");
    }

    @Test
    public void testCsvToJson() {
        JsonCsvConverter.csvToJson();
        File jsonFile = new File(jsonFilePath);
        assertTrue(jsonFile.exists(), "JSON file was not created.");
    }
}
