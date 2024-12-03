package org.example.part_2.part_C;

public class MaximumConsecutiveElements {
    public int findMaxConsecutive(int[][] matrix) {
        int maxCount = 0;

        for (int[] row : matrix) {
            int count = 1;
            for (int j = 1; j < row.length; j++) {
                if (row[j] > row[j - 1]) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        for (int j = 0; j < matrix[0].length; j++) {
            int count = 1;
            for (int i = 1; i < matrix.length; i++) {
                if (matrix[i][j] > matrix[i - 1][j]) {
                    count++;
                } else {
                    maxCount = Math.max(maxCount, count);
                    count = 1;
                }
            }
            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
