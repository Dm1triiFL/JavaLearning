package org.example.part_10.part_C;

import org.example.part_10.part_C.WordSearcher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordSearcherTest {

    private WordSearcher wordSearcher;
    private Path tempOutputFilePath;

    @BeforeEach
    public void setUp() {
        wordSearcher = new WordSearcher();
    }

    @AfterEach
    public void tearDown() throws IOException {
        if (tempOutputFilePath != null) {
            Files.deleteIfExists(tempOutputFilePath);
        }
    }

    @Test
    public void testWriteWordsToFile() throws IOException {
        List<String> wordsToWrite = Arrays.asList("word1", "word2");

        tempOutputFilePath = Files.createTempFile("testOutput", ".txt");
        wordSearcher.writeWordsToFile(wordsToWrite, tempOutputFilePath.toString());
        List<String> lines = Files.readAllLines(tempOutputFilePath);

        assertEquals(wordsToWrite, lines);
    }
}
