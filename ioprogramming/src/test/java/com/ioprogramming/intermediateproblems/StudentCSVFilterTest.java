package com.ioprogramming.intermediateproblems;

import org.junit.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StudentCSVFilterTest {

    private static final String TEST_CSV_FILE = "E:/Capg/Week5_IO_Programming/Day1/src/test/resources/test_students.csv";

    @Test
    public void testFilterStudents() throws IOException {
        // Create a test CSV file
        createTestCSV();

        // Capture output
        List<String> lines = Files.readAllLines(Paths.get(TEST_CSV_FILE));
        long count = lines.stream().skip(1) // Skip header
                .filter(line -> Integer.parseInt(line.split(",")[3]) > 80)
                .count();
        assertEquals(3, count); // Expecting 2 students with marks > 80
    }

    private void createTestCSV() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TEST_CSV_FILE))) {
            writer.println("ID,Name,Age,Marks");
            writer.println("101,Anand,20,85");
            writer.println("102,Avinash,21,78");
            writer.println("103,Saurabh,22,90");
            writer.println("104,Ankit,23,76");
            writer.println("105,Aakrati,19,82");
        }
    }
}

