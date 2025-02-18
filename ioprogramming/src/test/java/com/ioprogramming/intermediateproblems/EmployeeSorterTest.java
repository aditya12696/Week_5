package com.ioprogramming.intermediateproblems;

import org.junit.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import static org.junit.Assert.*;

public class EmployeeSorterTest {

    private static final String TEST_CSV_FILE = "E:/Capg/Week5_IO_Programming/Day1/src/test/resources/test_employees.csv";

    @Test
    public void testSortingBySalary() throws IOException {
        createTestCSV();

        List<String> lines = Files.readAllLines(Paths.get(TEST_CSV_FILE));
        assertTrue(lines.get(1).contains("Anand"));
    }

    private void createTestCSV() throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TEST_CSV_FILE))) {
            writer.println("ID,Name,Department,Salary");
            writer.println("101,Anand,HR,500000");
            writer.println("102,Avinash,IT,50000");
        }
    }
}

