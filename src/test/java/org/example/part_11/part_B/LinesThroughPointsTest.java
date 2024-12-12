package org.example.part_11.part_B;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LinesThroughPointsTest {
    private static final String INPUT_FILE = "src/test/resources/input.txt";
    private static final String OUTPUT_FILE = "src/test/resources/output.txt";

    @BeforeEach
    void setUp() throws IOException {
        new File(OUTPUT_FILE).delete();
    }

    @Test
    void testReadPointsFromFile_ValidFile() throws IOException {
        // Подготовка файла с тестовыми данными
        writeTestData(INPUT_FILE, "1,2\n3,4\n5,6");

        List<Point> points = LinesThroughPoints.readPointsFromFile(INPUT_FILE);
        assertEquals(3, points.size());
        assertEquals(1, points.get(0).x);
        assertEquals(2, points.get(0).y);
        assertEquals(3, points.get(1).x);
        assertEquals(4, points.get(1).y);
        assertEquals(5, points.get(2).x);
        assertEquals(6, points.get(2).y);
    }

    @Test
    void testGetLineKey_ValidPoints() {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(3, 4);
        String lineKey = LinesThroughPoints.getLineKey(p1, p2);
        assertEquals("y = 1/1x + 1", lineKey);
    }


    private void writeTestData(String fileName, String data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data);
        }
    }
}
