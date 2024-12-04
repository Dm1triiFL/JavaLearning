package org.example.part_8.part_B;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveWordsTest {

    @Test
    public void testSingleWordRemoved() {
        String text = "This is a test.";
        int length = 4;
        String result = RemoveWords.removeWords(text, length);
        assertEquals("is a test.", result);
    }

    @Test
    public void testRemoveWords_MultipleWordsRemoved() {
        String text = "Here is a long statement about cats.";
        int length = 2;
        String result = RemoveWords.removeWords(text, length);
        assertEquals("Here is long statement about cats.", result); // "is" removed
    }

    @Test
    public void testRemoveWords_NoWordsMatch() {
        String text = "An example of a test.";
        int length = 5;
        String result = RemoveWords.removeWords(text, length);
        assertEquals("An example of a test.", result); // No words removed
    }

    @Test
    public void testRemoveWords_AllWordsRemoved() {
        String text = "A big dog ran by.";
        int length = 3;
        String result = RemoveWords.removeWords(text, length);
        assertEquals("", result); // All words removed
    }

    @Test
    public void testRemoveWords_LeadingAndTrailingSpaces() {
        String text = "   An apple a day keeps the doctor away.   ";
        int length = 3;
        String result = RemoveWords.removeWords(text, length);
        assertEquals("apple day keeps doctor away.", result); // "An" removed
    }

    @Test
    public void testRemoveWords_OnlyConsonantWordsRemoved() {
        String text = "Eat cake or pie.";
        int length = 3;
        String result = RemoveWords.removeWords(text, length);
        assertEquals("Eat or pie.", result); // "cake" removed
    }
}
