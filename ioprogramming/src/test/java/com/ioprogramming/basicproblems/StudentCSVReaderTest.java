package com.ioprogramming.basicproblems;

import org.junit.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class StudentCSVReaderTest {

    private static final String TEST_CSV_FILE = "E:/Capg/Week5_IO_Programming/Day1/src/test/resources/test_students.csv";

    @Test
    public void testReadCSV() throws IOException {
        createTestCSV();
        StudentCSVReader.readCSV(TEST_CSV_FILE);
        assertTrue(Files.exists(Paths.get(TEST_CSV_FILE)));
    }

    private void createTestCSV() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TEST_CSV_FILE))) {
            writer.println("1,Anand,22,85");
            writer.println("2,Anshika,21,90");
        }
    }
}
