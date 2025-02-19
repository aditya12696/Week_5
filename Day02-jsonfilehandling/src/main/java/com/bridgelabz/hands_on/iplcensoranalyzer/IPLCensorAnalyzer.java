package com.bridgelabz.hands_on.iplcensoranalyzer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.List;

public class IPLCensorAnalyzer {
    public static void main(String[] args) {
        // Process JSON and CSV Files
        censorJSON("D:\\local\\Week_5\\Day02-jsonfilehandling\\src\\main\\resources\\ipl_matches.json", "censored_ipl.json");
        censorCSV("D:\\local\\Week_5\\Day02-jsonfilehandling\\src\\main\\resources\\ipl_matches.csv", "censored_ipl.csv");
    }

    // Method to censor JSON data
    private static void censorJSON(String inputFile, String outputFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Read JSON file
            JsonNode rootNode = objectMapper.readTree(new File(inputFile));
            ArrayNode censoredArray = objectMapper.createArrayNode();

            for (JsonNode node : rootNode) {
                ObjectNode matchNode = (ObjectNode) node;
                matchNode.put("team1", censorTeamName(matchNode.get("team1").asText()));
                matchNode.put("team2", censorTeamName(matchNode.get("team2").asText()));
                matchNode.put("player_of_the_match", "REDACTED");
                censoredArray.add(matchNode);
            }

            // Write sanitized JSON
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), censoredArray);
            System.out.println("Censored JSON file generated: " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to censor CSV data
    private static void censorCSV(String inputFile, String outputFile) {
        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            List<String[]> allRows = reader.readAll();
            writer.writeNext(allRows.get(0)); // Write header

            for (int i = 1; i < allRows.size(); i++) {
                String[] row = allRows.get(i);
                row[1] = censorTeamName(row[1]); // Censor team1
                row[2] = censorTeamName(row[2]); // Censor team2
                row[3] = "REDACTED"; // Redact Player of the Match
                writer.writeNext(row);
            }

            System.out.println("Censored CSV file generated: " + outputFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Censor team name (replace last word with "***")
    private static String censorTeamName(String teamName) {
        String[] words = teamName.split(" ");
        if (words.length > 1) {
            words[words.length - 1] = "***";
        }
        return String.join(" ", words);
    }
}
