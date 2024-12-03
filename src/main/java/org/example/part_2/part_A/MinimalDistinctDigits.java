package org.example.part_2.part_A;

import java.util.HashSet;

public class MinimalDistinctDigits {
    public static void findNumberWithMinDistinctDigits(String[] numbers) {
        String result = null;
        int minDistinctCount = Integer.MAX_VALUE;

        for (String number : numbers) {
            HashSet<Character> distinctDigits = new HashSet<>();
            for (char c : number.toCharArray()) {
                distinctDigits.add(c);
            }
            int distinctCount = distinctDigits.size();

            if (distinctCount < minDistinctCount) {
                minDistinctCount = distinctCount;
                result = number;
            }
        }

        if (result != null) {
            System.out.println("Число с минимальным количеством различных цифр: " + result);
        }
    }
}
