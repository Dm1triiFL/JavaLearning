package org.example.part_2.part_C;


public class SumBetweenPositive {
    public void sumElementsBetweenPositive(int[][] matrix) {
        for (int[] row : matrix) {
            int firstPositiveIndex = -1;
            int secondPositiveIndex = -1;
            for (int j = 0; j < row.length; j++) {
                if (row[j] > 0) {
                    if (firstPositiveIndex == -1) {
                        firstPositiveIndex = j;
                    } else {
                        secondPositiveIndex = j;
                        break;
                    }
                }
            }
            if (firstPositiveIndex != -1 && secondPositiveIndex != -1) {
                int sum = 0;
                for (int j = firstPositiveIndex + 1; j < secondPositiveIndex; j++) {
                    sum += row[j];
                }
                System.out.println("Сумма между положительными элементами: " + sum);
            }
        }
    }
}
