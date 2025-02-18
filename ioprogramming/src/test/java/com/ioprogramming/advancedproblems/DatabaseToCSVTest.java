package com.ioprogramming.advancedproblems;

import com.ioprogramming.advancedproblems.csvfromdatabase.DatabaseToCSV;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseToCSVTest {

    private final String testFilePath = "employees.csv";

    @Test
    public void testCSVExport() {
        DatabaseToCSV.exportToCSV();
        File csvFile = new File(testFilePath);
        assertTrue(csvFile.exists(), "CSV file was not created.");
    }
}
