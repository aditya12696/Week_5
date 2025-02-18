package com.ioprogramming.advancedproblems;


import com.ioprogramming.advancedproblems.encryptanddecryptdata.CsvEncryptor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CsvProcessorTest {

    @Test
    void testEncryptionDecryption() throws Exception {
        String originalText = "anandsoni9165@gmail.com";
        String encryptedText = CsvEncryptor.encrypt(originalText);
        String decryptedText = CsvEncryptor.decrypt(encryptedText);

        assertNotEquals(originalText, encryptedText, "Encryption should change the text");
        assertEquals(originalText, decryptedText, "Decryption should restore the original text");
    }
}

