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
        // Создаем входной файл для тестирования
        Files.createDirectories(Paths.get(OUTPUT_DIR));
        List<String> lines = Arrays.asList(
                "кот кошка капуста карандаш",
                "собака курица крокодил",
                "кафе книга кино",
                "молоко кофе"
        );
        Files.write(Paths.get(INPUT_FILE_PATH), lines);
    }


    @Test
    public void testFindWords() throws IOException {
        // Проверка работы метода findWords
        WordSearch.findWords("к*", INPUT_FILE_PATH, OUTPUT_DIR);

        // Читаем выходной файл
        List<String> expectedWords = Arrays.asList("кот", "кошка", "капуста", "карандаш", "курица", "крокодил", "кафе", "книга", "кино", "кофе");
        List<String> outputWords = Files.readAllLines(Paths.get(OUTPUT_DIR, "output.txt"));

        // Сравниваем найденные слова с ожидаемыми
        assertTrue(outputWords.containsAll(expectedWords), "Выходные слова не содержат все ожидаемые слова.");
    }

    @Test
    public void testNoWordsFound() throws IOException {
        // Проверка для шаблона, который не должен находить слов
        WordSearch.findWords("z*", INPUT_FILE_PATH, OUTPUT_DIR);

        List<String> outputWords = Files.readAllLines(Paths.get(OUTPUT_DIR, "output.txt"));
        assertTrue(outputWords.isEmpty(), "Файл не должен содержать слова.");
    }
}
