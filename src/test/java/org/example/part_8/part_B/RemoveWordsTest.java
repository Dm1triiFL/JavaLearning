package org.example.part_8.part_B;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveWordsTest {

    @Test
    public void testSingleWordRemoved() {
        String text = "This is a.";
        int length = 4;
        String result = RemoveWords.removeWords(text, length);
        assertEquals("is a.", result);
    }

    @Test
    public void testNoWordsMatch() {
        String text = "An example of a test.";
        int length = 5;
        String result = RemoveWords.removeWords(text, length);
        assertEquals("An example of a test.", result);
    }

    @Test
    public void testAllWordsRemoved() {
        String text = "big dog ran";
        int length = 3;
        String result = RemoveWords.removeWords(text, length);
        assertEquals("", result); // All words removed
    }

}
