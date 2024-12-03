package org.example.part_1.part_A;
import java.util.Random;

public class RandomNumbers {
    public void printRandomNumbers(int count, boolean newline) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            System.out.print(random.nextInt(100) + (newline ? "\n" : " "));
        }
        if (!newline) {
            System.out.println();
        }
    }
}
