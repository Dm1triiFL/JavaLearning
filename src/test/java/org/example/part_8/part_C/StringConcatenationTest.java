package org.example.part_8.part_C;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringConcatenationTest {

    private static final int CHAR_COUNT = 1_000;

    @Test
    public void testString() {
        String str = "";
        for (int i = 0; i < CHAR_COUNT; i++) {
            str += 'a';
        }
        assertEquals("a".repeat(CHAR_COUNT), str);
    }

    @Test
    public void testStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < CHAR_COUNT; i++) {
            stringBuilder.append('a');
        }
        assertEquals("a".repeat(CHAR_COUNT), stringBuilder.toString());
    }

    @Test
    public void testPerformanceStringBuilder() {
        long startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 1_000_000; i++) {
            stringBuilder.append('a');
        }
        long duration = System.nanoTime() - startTime;


        System.out.println("Время для StringBuilder: " + duration + " нс");
        assert (duration < 100_000_000); //
    }

    @Test
    public void testPerformanceString() {
        long startTime = System.nanoTime();
        String str = "";
        for (int i = 0; i < 1_000_000; i++) {
            str += 'a';
        }
        long duration = System.nanoTime() - startTime;


        System.out.println("Время для String: " + duration + " нс");
        assert (duration >= 100_000_000);
    }
}
