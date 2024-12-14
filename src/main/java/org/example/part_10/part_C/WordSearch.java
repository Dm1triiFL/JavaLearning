package org.example.part_10.part_C;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class WordSearch {

    public static void findWords(String template, String inputFile, String outputDir) throws IOException {
        File dir = new File(outputDir);
        if (!dir.exists()) {
            dir.mkdir();
        }

        String outputFile = outputDir + File.separator + "output.txt";

        String regexPattern = "^" + template.replace("*", ".*") + "$";
        Pattern pattern = Pattern.compile(regexPattern);

        List<String> wordsFound = new ArrayList<>();

        List<String> lines = Files.readAllLines(Paths.get(inputFile));

        for (String line : lines) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                Matcher matcher = pattern.matcher(word);
                if (matcher.matches()) {
                    wordsFound.add(word);
                }
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String word : wordsFound) {
                writer.write(word);
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) {
        try {
            findWords("к*", "src\\main\\resources\\part_10\\part_C\\input.txt", "output_directory");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
