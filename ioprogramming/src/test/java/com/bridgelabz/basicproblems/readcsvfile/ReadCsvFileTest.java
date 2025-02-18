package com.bridgelabz.basicproblems.readcsvfile;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.StringReader;

import static org.mockito.Mockito.*;

public class ReadCsvFileTest {

    @Test
    public void testCsvReading() throws IOException, CsvValidationException {
        // Sample CSV data as String
        String csvData = "101,John,20,85\n102,Alice,21,90\n";

        // Mocking CSVReader
        CSVReader mockReader = new CSVReader(new StringReader(csvData));

        // Mock behavior for reading lines
        when(mockReader.readNext())
                .thenReturn(new String[]{"101", "John", "20", "85"})
                .thenReturn(new String[]{"102", "Alice", "21", "90"})
                .thenReturn(null); // No more data

        // Simulating file reading logic
        String[] nextLine;
        while ((nextLine = mockReader.readNext()) != null) {
            System.out.println("Student ID: " + nextLine[0] + ", Name: " + nextLine[1] +
                    ", Age: " + nextLine[2] + ", Marks: " + nextLine[3]);
        }

        // Verify method invocations
        verify(mockReader, atLeastOnce()).readNext();
        mockReader.close();
    }
}
