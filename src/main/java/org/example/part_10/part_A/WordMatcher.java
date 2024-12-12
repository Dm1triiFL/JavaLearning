package org.example.part_10.part_A;
import java.io.*;

public class WordMatcher {

    public static void main(String[] args) {
        //"Шубин Дмитрий Б762-2" Вариант 4
        String inputFilePath = "";
        String outputFilePath = "";


        if (args.length == 2) {
            inputFilePath = args[0];
            outputFilePath = args[1];
        }
        else if (args.length == 1) {
            String configFilePath = args[0];
            try (BufferedReader configReader = new BufferedReader(new FileReader(configFilePath))) {
                inputFilePath = configReader.readLine();
                outputFilePath = configReader.readLine();
            } catch (IOException e) {
                System.err.println("ошибка при чтении конфигурационного файла: " + e.getMessage());
                return;
            }
        } else {
            System.out.println("Использование:   java WordMatcher  <Входной файл>   <выходной файл> ИЛИ java   WordMatcher <Конфигурационный файл>");
            return;
        }

        WordMatcher matcher = new WordMatcher();
        matcher.processFiles(inputFilePath, outputFilePath);
    }

    public void processFiles(String inputFilePath, String outputFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (int i = 0; i < words.length - 1; i++) {
                    String currentWord = words[i];
                    String nextWord = words[i + 1];

                    if (!currentWord.isEmpty() && !nextWord.isEmpty()) {
                        char lastChar = currentWord.charAt(currentWord.length() - 1);
                        char firstChar = nextWord.charAt(0);

                        if (Character.toLowerCase(lastChar) == Character.toLowerCase(firstChar)) {
                            writer.write(currentWord + " -> " + nextWord);
                            writer.newLine();
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
