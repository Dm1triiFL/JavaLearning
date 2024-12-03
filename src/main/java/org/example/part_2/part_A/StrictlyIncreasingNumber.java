package org.example.part_2.part_A;

public class StrictlyIncreasingNumber {
    public static void findStrictlyIncreasing(String[] numbers) {
        for (String number : numbers) {
            if (isStrictlyIncreasing(number)) {
                System.out.println("Число с цифрами в строгом порядке возрастания: " + number);
                return;
            }
        }
        System.out.println("Нет чисел с цифрами в строго возрастающем порядке.");
    }

    private static boolean isStrictlyIncreasing(String number) {
        for (int i = 0; i < number.length() - 1; i++) {
            if (number.charAt(i) >= number.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
