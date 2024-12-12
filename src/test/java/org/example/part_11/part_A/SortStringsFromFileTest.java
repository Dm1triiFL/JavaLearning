package org.example.part_11.part_A;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortStringsFromFileTest {
    private SortStringsFromFile sorter;
    private Path tempFile;
    private PrintStream originalOut;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() throws IOException {
        tempFile = Files.createTempFile("testStrings", ".txt");
        sorter = new SortStringsFromFile(tempFile.toString());

        originalOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    public void tearDown() throws IOException {
        Files.deleteIfExists(tempFile);
        System.setOut(originalOut);
    }

    @Test
    public void testReadLines() throws IOException {
        try (FileWriter writer = new FileWriter(tempFile.toFile())) {
            writer.write("banana\napple\ncherry\n");
        }

        List<String> lines = sorter.readLines();

        assertEquals(3, lines.size());
        assertEquals("banana", lines.get(0));
        assertEquals("apple", lines.get(1));
        assertEquals("cherry", lines.get(2));
    }


}
