package com.ioprogramming.intermediateproblems;

import org.junit.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class EmployeeSearchTest {

    private static final String TEST_CSV_FILE = "E:/Capg/Week5_IO_Programming/Day1/src/test/resources/test_employees.csv";

    @Test
    public void testSearchEmployee() throws IOException {
        // Create a test CSV file
        createTestCSV();

        // Read the file and check if "Charlie" is present
        List<String> lines = Files.readAllLines(Paths.get(TEST_CSV_FILE));
        boolean found = lines.stream().anyMatch(line -> line.contains("Anand"));
        assertTrue(found);
    }

    private void createTestCSV() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TEST_CSV_FILE))) {
            writer.println("ID,Name,Department,Salary");
            writer.println("101,Anand,HR,50000");
            writer.println("102,Avinash,IT,60000");
            writer.println("103,Ankit,Finance,55000");
            writer.println("104,Anshika,Marketing,58000");
            writer.println("105,Aakrati,Sales,62000");
        }
    }
}
