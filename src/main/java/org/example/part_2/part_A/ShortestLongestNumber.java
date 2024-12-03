package org.example.part_2.part_A;

public class ShortestLongestNumber {
    public static void findShortestAndLongest(String[] numbers) {
        String shortest = numbers[0];
        String longest = numbers[0];

        for (String number : numbers) {
            if (number.length() < shortest.length()) {
                shortest = number;
            }
            if (number.length() > longest.length()) {
                longest = number;
            }
        }

        System.out.println("Самое короткое число: " + shortest + " (длина: " + shortest.length() + ")");
        System.out.println("Самое длинное число: " + longest + " (длина: " + longest.length() + ")");
    }
}
