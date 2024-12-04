package org.example.part_8.part_A;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WordCounterTest {

    @Test
    void testWithVowels() {
        String text = "An apple a day keeps the doctor away.";
        int count = WordCounter.countWords(text);
        assertEquals(2, count);
    }

    @Test
    void testWithNoVowelWords() {
        String text = "This text contains no words that fit.";
        int count = WordCounter.countWords(text);
        assertEquals(0, count);
    }

    @Test
    void testEmptyString() {
        String text = "";
        int count = WordCounter.countWords(text);
        assertEquals(0, count);
    }

    @Test
    void testSingleCharacter() {
        String text = "A E I O U";
        int count = WordCounter.countWords(text);
        assertEquals(5, count);
    }

    @Test
    void testMixedCase() {
        String text = "An Apple A day keeps the doctor Away.";
        int count = WordCounter.countWords(text);
        assertEquals(2, count);
    }
}
