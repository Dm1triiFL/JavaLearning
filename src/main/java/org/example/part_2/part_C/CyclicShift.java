package org.example.part_2.part_C;

public class CyclicShift {
    public void shiftRight(int[][] matrix, int k) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int temp = matrix[i][n - 1];
                for (int m = n - 1; m > 0; m--) {
                    matrix[i][m] = matrix[i][m - 1];
                }
                matrix[i][0] = temp;
            }
        }
    }

    public void shiftLeft(int[][] matrix, int k) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int temp = matrix[i][0];
                for (int m = 0; m < n - 1; m++) {
                    matrix[i][m] = matrix[i][m + 1];
                }
                matrix[i][n - 1] = temp;
            }
        }
    }

    public void shiftUp(int[][] matrix, int k) {
        int n = matrix.length;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < k; i++) {
                int temp = matrix[0][j];
                for (int m = 0; m < n - 1; m++) {
                    matrix[m][j] = matrix[m + 1][j];
                }
                matrix[n - 1][j] = temp;
            }
        }
    }

    public void shiftDown(int[][] matrix, int k) {
        int n = matrix.length;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < k; i++) {
                int temp = matrix[n - 1][j];
                for (int m = n - 1; m > 0; m--) {
                    matrix[m][j] = matrix[m - 1][j];
                }
                matrix[0][j] = temp;
            }
        }
    }
}
