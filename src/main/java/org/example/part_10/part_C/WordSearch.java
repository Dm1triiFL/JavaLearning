package org.example.part_10.part_C;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class WordSearch {

    public static void findWords(String template, String inputFile, String outputDir) throws IOException {
        // Создание директории, если она не существует
        File dir = new File(outputDir);
        if (!dir.exists()) {
            dir.mkdir();
        }

        // Имя выходного файла
        String outputFile = outputDir + File.separator + "output.txt";

        // Преобразуем шаблон в регулярное выражение
        String regexPattern = "^" + template.replace("*", ".*") + "$";
        Pattern pattern = Pattern.compile(regexPattern);

        List<String> wordsFound = new ArrayList<>();

        // Читаем строки из входного файла
        List<String> lines = Files.readAllLines(Paths.get(inputFile));

        for (String line : lines) {
            // Разделяем строку на слова
            String[] words = line.split("\\s+");
            for (String word : words) {
                Matcher matcher = pattern.matcher(word);
                if (matcher.matches()) {
                    wordsFound.add(word);
                }
            }
        }

        // Записываем найденные слова в выходной файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String word : wordsFound) {
                writer.write(word);
                writer.newLine();
            }
        }
    }

    public static void main(String[] args) {
        try {
            findWords("к*", "input.txt", "output_directory"); // Укажите желаемое имя директории
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
