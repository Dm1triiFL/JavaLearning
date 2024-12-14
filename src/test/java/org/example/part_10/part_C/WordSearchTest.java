package org.example.part_10.part_C;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class WordSearchTest {

    private static final String INPUT_FILE_PATH = "src/test/resources/input.txt";
    private static final String OUTPUT_DIR = "src/test/resources/output_directory";

    @BeforeEach
    public void setUp() throws IOException {
        Files.createDirectories(Paths.get(OUTPUT_DIR));
        List<String> lines = Arrays.asList(
                "кот кошка капуста карандаш",
                "собака курица крокодил",
                "кафе книга кино",
                "молоко кофе"
        );
        Files.write(Paths.get(INPUT_FILE_PATH), lines);
    }

    @AfterEach
    public void tearDown() throws IOException {
        Path outputPath = Paths.get(OUTPUT_DIR, "output.txt");
        if (Files.exists(outputPath)) {
            Files.delete(outputPath);
        }
        Files.deleteIfExists(Paths.get(OUTPUT_DIR));
        Files.deleteIfExists(Paths.get(INPUT_FILE_PATH));
    }

    @Test
    public void testFindWords() throws IOException {
        WordSearch.findWords("к*", INPUT_FILE_PATH, OUTPUT_DIR);

        List<String> expectedWords = Arrays.asList("кот", "кошка", "капуста", "карандаш", "курица", "крокодил", "кафе", "книга", "кино", "кофе");
        List<String> outputWords = Files.readAllLines(Paths.get(OUTPUT_DIR, "output.txt"));

        assertTrue(outputWords.containsAll(expectedWords), "Выходные слова не содержат все ожидаемые слова.");
    }

    @Test
    public void testNoWordsFound() throws IOException {
        WordSearch.findWords("z*", INPUT_FILE_PATH, OUTPUT_DIR);

        List<String> outputWords = Files.readAllLines(Paths.get(OUTPUT_DIR, "output.txt"));
        assertTrue(outputWords.isEmpty(), "Файл не должен содержать слова.");
    }
}
