package org.example.part_2.part_C;

import java.util.Random;

public class MatrixGenerator {
    public static int[][] generateMatrix(int n) {
        Random random = new Random();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(2 * n + 1) - n; // В интервале от -n до n
            }
        }
        return matrix;
    }
}

