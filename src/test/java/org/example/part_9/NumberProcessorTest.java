package org.example.part_9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class NumberProcessorTest {

    private NumberProcessor numberProcessor;
    private String validFilePath;
    private String invalidFilePath;

    @BeforeEach
    void setUp() throws IOException {

        validFilePath = "src/test/resources/valid_numbers.txt";
        invalidFilePath = "src/test/resources/invalid_numbers.txt";

        createValidTestFile(validFilePath);
        createInvalidTestFile(invalidFilePath);
    }

    void createValidTestFile(String path) throws IOException {
        try (FileWriter writer = new FileWriter(new File(path))) {
            writer.write("1000,en\n");
            writer.write("2000,fr\n");
            writer.write("5000,en\n");
        }
    }

    void createInvalidTestFile(String path) throws IOException {
        try (FileWriter writer = new FileWriter(new File(path))) {
            writer.write("1000,en\n");
            writer.write("notANumber,en\n");
            writer.write("20000,en\n");
        }
    }

    @Test
    void testReadFileValidData() throws Exception {
        numberProcessor = new NumberProcessor(validFilePath);
        numberProcessor.readFile();

        assertEquals(3, numberProcessor.numbers.size());
        assertEquals(8000.0, numberProcessor.calculateSum());
        assertEquals(2666.67, numberProcessor.calculateAverage(), 0.01);
    }

    @Test

    void testReadFileInvalidData() {
        numberProcessor = new NumberProcessor(invalidFilePath);

        try {
            numberProcessor.readFile();
        } catch (FileError | MemoryError e) {
            fail("Исключение было выброшено: " + e.getMessage());
        }

        assertEquals(1, numberProcessor.numbers.size());
        assertTrue(numberProcessor.numbers.contains(1000.0));

    }




    @Test
    void testCalculateAverageWithNoNumbers() {
        numberProcessor = new NumberProcessor(validFilePath);

        Exception exception = assertThrows(InvalidValueError.class, () -> {
            numberProcessor.calculateAverage();
        });

        assertNotNull(exception);
        assertEquals("Нет чисел для вычисления.", exception.getMessage());
    }

    @Test
    void testInvalidLocale() {
        numberProcessor = new NumberProcessor(validFilePath);

        Exception exception = assertThrows(InvalidValueError.class, () -> {
            numberProcessor.processNumber("123.45", "invalidLocale");
        });

        assertNotNull(exception);
        assertEquals("Неподдерживаемая локаль: invalidLocale", exception.getMessage());
    }
}
