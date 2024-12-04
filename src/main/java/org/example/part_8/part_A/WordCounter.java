package org.example.part_8.part_A;

import java.util.Arrays;

public class WordCounter {

    public static int countWords(String text) {
        String vowels = "aeiouAEIOU";

        return (int) Arrays.stream(text.split("\\W+"))
                .filter(word -> word.length() > 0)
                .filter(word -> vowels.indexOf(word.charAt(0)) != -1 && vowels.indexOf(word.charAt(word.length() - 1)) != -1)
                .count();
    }
}
