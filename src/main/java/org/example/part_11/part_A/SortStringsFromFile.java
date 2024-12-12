package org.example.part_11.part_A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortStringsFromFile {

    private String filePath;

    public SortStringsFromFile(String filePath) {
        this.filePath = filePath;
    }

    public List<String> readLines() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void sortAndPrintLines() {
        List<String> lines = readLines();
        Collections.sort(lines);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        String filePath = "src\\main\\resources\\part_11\\part_A\\strings.txt";
        SortStringsFromFile sorter = new SortStringsFromFile(filePath);
        sorter.sortAndPrintLines();
    }
}
