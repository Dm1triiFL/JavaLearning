package org.example.part_2.part_A;

import java.util.Arrays;

public class SortNumbersByLength {
    public static void sortAndDisplay(String[] numbers, boolean ascending) {
        Arrays.sort(numbers, (a, b) -> {
            int lengthDiff = Integer.compare(a.length(), b.length());
            return ascending ? lengthDiff : -lengthDiff;
        });

        System.out.println("Числа в порядке " + (ascending ? "возрастания" : "убывания") + " длины:");
        for (String number : numbers) {
            System.out.println(number);
        }
    }
}
