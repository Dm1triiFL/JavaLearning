package org.example.part_10.part_A;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class WordMatcherTest {

    private File inputFile;
    private File outputFile;
    private WordMatcher matcher;

    @BeforeEach
    public void setUp() throws IOException {
        inputFile = File.createTempFile("input", ".txt");
        outputFile = File.createTempFile("output", ".txt");
        matcher = new WordMatcher();
    }

    @Test
    public void testMatchingWords() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            writer.write("hello orange\n");
            writer.write("apple eclair\n");
            writer.write("test start\n");
            writer.write("midday dawn\n");
        }

        matcher.processFiles(inputFile.getAbsolutePath(), outputFile.getAbsolutePath());

        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
        }

        String expectedOutput = "hello -> orange\n" +
                "apple -> eclair\n";

        assertEquals(expectedOutput.trim(), result.toString().trim());
    }


    @Test
    public void testNoMatches() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            writer.write("One two three\n");
            writer.write("Four five six\n");
        }

        matcher.processFiles(inputFile.getAbsolutePath(), outputFile.getAbsolutePath());

        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
        }

        assertEquals("", result.toString().trim());
    }

    @Test
    public void testEmptyInputFile() throws IOException {
        matcher.processFiles(inputFile.getAbsolutePath(), outputFile.getAbsolutePath());

        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
        }

        assertEquals("", result.toString().trim());
    }

    @Test
    public void testSingleWordLines() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile))) {
            writer.write("Single\n");
            writer.write("Word\n");
            writer.write("Lines\n");
        }

        matcher.processFiles(inputFile.getAbsolutePath(), outputFile.getAbsolutePath());

        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(outputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
        }

        assertEquals("", result.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        inputFile.delete();
        outputFile.delete();
    }
}
