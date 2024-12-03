package org.example.part_2.part_C;


public class Determinant {
    public double calculateDeterminant(double[][] matrix) {
        int n = matrix.length;
        if (n == 1) return matrix[0][0];
        if (n == 2) return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        double det = 0;
        for (int p = 0; p < n; p++) {
            double[][] subMatrix = new double[n - 1][n - 1];
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j < p) {
                        subMatrix[i - 1][j] = matrix[i][j];
                    } else if (j > p) {
                        subMatrix[i - 1][j - 1] = matrix[i][j];
                    }
                }
            }
            det += Math.pow(-1, p) * matrix[0][p] * calculateDeterminant(subMatrix);
        }
        return det;
    }
}

