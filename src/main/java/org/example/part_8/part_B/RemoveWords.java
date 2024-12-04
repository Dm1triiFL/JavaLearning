package org.example.part_8.part_B;

public class RemoveWords {

    public static String removeWords(String text, int length) {
        String regex = "\\b[^aeiouAEIOU\\W]\\w{" + (length - 1) + "}\\b";
        return text.replaceAll(regex, "").replaceAll("\\s+", " ").trim();
    }
}
