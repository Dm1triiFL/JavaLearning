package org.example.part_2.part_A;

public class PalindromeNumber {
    public static void findPalindrome(String[] numbers) {
        int palindromeCount = 0;
        String secondPalindrome = null;

        for (String number : numbers) {
            if (isPalindrome(number)) {
                palindromeCount++;
                if (palindromeCount == 2) {
                    secondPalindrome = number;
                    break;
                }
            }
        }

        if (palindromeCount > 1) {
            System.out.println("Второе число-палиндром: " + secondPalindrome);
        } else {
            System.out.println("Нет второго числа-палиндрома.");
        }
    }

    private static boolean isPalindrome(String number) {
        return new StringBuilder(number).reverse().toString().equals(number);
    }
}
