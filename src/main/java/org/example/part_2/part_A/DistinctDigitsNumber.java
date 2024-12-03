package org.example.part_2.part_A;

import java.util.HashSet;

public class DistinctDigitsNumber {
    public static void findNumberWithDistinctDigits(String[] numbers) {
        for (String number : numbers) {
            if (hasDistinctDigits(number)) {
                System.out.println("Первое число с различными цифрами: " + number);
                return;
            }
        }
        System.out.println("Нет чисел с различными цифрами.");
    }

    private static boolean hasDistinctDigits(String number) {
        HashSet<Character> seen = new HashSet<>();
        for (char c : number.toCharArray()) {
            if (seen.contains(c)) {
                return false;
            }
            seen.add(c);
        }
        return true;
    }
}
