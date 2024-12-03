package org.example.part_2.part_C;


public class RotateMatrix {
    public double[][] rotate90Degrees(double[][] matrix) {
        int n = matrix.length;
        double[][] rotated = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }
        return rotated;
    }

    public double[][] rotate180Degrees(double[][] matrix) {
        return rotate90Degrees(rotate90Degrees(matrix));
    }

    public double[][] rotate270Degrees(double[][] matrix) {
        return rotate90Degrees(rotate180Degrees(matrix));
    }
}
