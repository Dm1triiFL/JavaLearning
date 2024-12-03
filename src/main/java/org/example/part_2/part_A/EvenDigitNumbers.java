package org.example.part_2.part_A;


public class EvenDigitNumbers {
    public static void analyzeEvenDigitNumbers(String[] numbers) {
        int countEven = 0;
        int balancedCount = 0;

        for (String number : numbers) {
            if (isEven(number)) {
                countEven++;
                if (isBalanced(number)) {
                    balancedCount++;
                }
            }
        }

        System.out.println("Количество чисел, содержащих только четные цифры: " + countEven);
        System.out.println("Количество чисел с равным количеством четных и нечетных цифр: " + balancedCount);
    }

    private static boolean isEven(String number) {
        for (char c : number.toCharArray()) {
            if ((c - '0') % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBalanced(String number) {
        int evenCount = 0, oddCount = 0;
        for (char c : number.toCharArray()) {
            if ((c - '0') % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        return evenCount == oddCount;
    }
}
