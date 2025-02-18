package com.bridgelabz.advancedproblems.encryptdecryptcsv;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

public class EncryptDecryptCSV {
    private static SecretKey secretKey;

    public static void main(String[] args) {
        try {
            // Generate encryption key
            secretKey = KeyGenerator.getInstance("AES").generateKey();

            // Encrypt and write CSV
            encryptAndWriteCSV("D:\\Capg\\Week_5\\ioprogramming\\src\\employee.csv", "encrypted_employees.csv");

            // Decrypt and read CSV
            decryptAndReadCSV("encrypted_employees.csv");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void encryptAndWriteCSV(String inputFile, String outputFile) throws Exception {
        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            String[] headers = reader.readNext();
            writer.writeNext(headers); // Write header row

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // Encrypt Salary and Email (assuming columns: ID, Name, Department, Salary, Email)
                nextLine[3] = encrypt(nextLine[3]); // Encrypt Salary
                nextLine[4] = encrypt(nextLine[4]); // Encrypt Email
                writer.writeNext(nextLine);
            }

            System.out.println("CSV file encrypted successfully!");
        }
    }

    private static void decryptAndReadCSV(String inputFile) throws Exception {
        try (CSVReader reader = new CSVReader(new FileReader(inputFile))) {
            String[] headers = reader.readNext();
            System.out.println(String.join(", ", headers));

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                // Decrypt Salary and Email
                nextLine[3] = decrypt(nextLine[3]); // Decrypt Salary
                nextLine[4] = decrypt(nextLine[4]); // Decrypt Email
                System.out.println(String.join(", ", nextLine));
            }

            System.out.println("CSV file decrypted successfully!");
        }
    }

    private static String encrypt(String value) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.getEncoder().encodeToString(cipher.doFinal(value.getBytes()));
    }

    private static String decrypt(String encryptedValue) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedValue)));
    }
}
