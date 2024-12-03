package org.example.part_2.part_A;

public class Main {
    public static void main(String[] args) {
        System.out.print("Шубин Дмитрий Б762-2 Вариант 12");

        ShortestLongestNumber.findShortestAndLongest(args);

        SortNumbersByLength.sortAndDisplay(args, true);  // По возрастанию длины
        SortNumbersByLength.sortAndDisplay(args, false); // По убыванию длины

        NumbersWithLengthComparison.compareWithAverageLength(args);

        MinimalDistinctDigits.findNumberWithMinDistinctDigits(args);

        EvenDigitNumbers.analyzeEvenDigitNumbers(args);

        StrictlyIncreasingNumber.findStrictlyIncreasing(args);

        DistinctDigitsNumber.findNumberWithDistinctDigits(args);

        PalindromeNumber.findPalindrome(args);

        if (args.length >= 3) {
            double a = Double.parseDouble(args[args.length - 3]);
            double b = Double.parseDouble(args[args.length - 2]);
            double c = Double.parseDouble(args[args.length - 1]);
            QuadraticEquationSolver.solve(a, b, c);
        }
    }
}
