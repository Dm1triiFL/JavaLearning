package org.example.part_11.part_A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortStringsFromFile {
    public static void main(String[] args) {
        String filePath = "src\\main\\resources\\part_11\\part_A\\strings.txt";
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(lines);

        for (String line : lines) {
            System.out.println(line);
        }
    }
}
