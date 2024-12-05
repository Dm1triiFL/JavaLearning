package org.example.part_10.part_C;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSearcher {

    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\dmshu\\IdeaProjects\\JavaLearning\\src\\main\\resources\\10_input_file.txt";
        String outputFilePath = "C:\\Users\\dmshu\\IdeaProjects\\JavaLearning\\src\\main\\resources\\10_output_file.txt";
        String patternString = "word";

        try {
            List<String> foundWords = searchWordsInFile(inputFilePath, patternString);
            writeWordsToFile(foundWords, outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> searchWordsInFile(String filePath, String patternString) throws IOException {
        List<String> foundWords = new ArrayList<>();
        Pattern pattern = Pattern.compile(patternString);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    Matcher matcher = pattern.matcher(word);
                    if (matcher.matches()) {
                        foundWords.add(word);
                    }
                }
            }
        }
        return foundWords;
    }

    public static void writeWordsToFile(List<String> words, String filePath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String word : words) {
                bw.write(word);
                bw.newLine();
            }
        }
    }
}

