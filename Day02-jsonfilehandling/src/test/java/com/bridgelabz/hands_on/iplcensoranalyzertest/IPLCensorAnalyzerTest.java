package com.bridgelabz.hands_on.iplcensoranalyzertest;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IPLCensorAnalyzerTest {
    @Test
    void testCensoredJSONFileExists() {
        File file = new File("censored_ipl.json");
        assertTrue(file.exists());
    }

    @Test
    void testCensoredCSVFileExists() {
        File file = new File("censored_ipl.csv");
        assertTrue(file.exists());
    }
}
