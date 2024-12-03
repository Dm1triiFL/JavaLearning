package org.example.part_2.part_A;


public class NumbersWithLengthComparison {
    public static void compareWithAverageLength(String[] numbers) {
        int totalLength = 0;

        for (String number : numbers) {
            totalLength += number.length();
        }

        double averageLength = (double) totalLength / numbers.length;

        System.out.println("Числа с длиной меньше средней (" + averageLength + "):");
        for (String number : numbers) {
            if (number.length() < averageLength) {
                System.out.println(number + " (длина: " + number.length() + ")");
            }
        }

        System.out.println("Числа с длиной больше средней (" + averageLength + "):");
        for (String number : numbers) {
            if (number.length() > averageLength) {
                System.out.println(number + " (длина: " + number.length() + ")");
            }
        }
    }
}

