package com.bridgelabz.basicproblems.writedata;

import com.opencsv.CSVWriter;
import org.junit.Test;

import java.io.StringWriter;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class WriteDataTest {

    @Test
    public void testCsvWriting() throws IOException {
        // Use StringWriter to capture output instead of mocking Writer
        StringWriter stringWriter = new StringWriter();
        CSVWriter csvWriter = new CSVWriter(stringWriter);

        // Sample data
        String[] header = {"ID", "Name", "Department", "Salary"};
        String[] emp1 = {"104", "Alice Williams", "Finance", "62000"};
        String[] emp2 = {"105", "Bob Johnson", "Sales", "58000"};

        // Write data
        csvWriter.writeNext(header);
        csvWriter.writeNext(emp1);
        csvWriter.writeNext(emp2);
        csvWriter.close();

        // Get CSV content
        String csvOutput = stringWriter.toString();

        // Assert output contains expected data
        assertTrue(csvOutput.contains("ID,Name,Department,Salary"));
        assertTrue(csvOutput.contains("104,Alice Williams,Finance,62000"));
        assertTrue(csvOutput.contains("105,Bob Johnson,Sales,58000"));
    }
}
