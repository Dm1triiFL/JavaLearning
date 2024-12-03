package org.example.part_2.part_C;


public class PrintMatrixNumbers {
    public void printMatrix(int k) {
        int[][] matrix = new int[k][k];
        int number = 1;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                matrix[i][j] = number++;
            }
        }

        System.out.println("Матрица N x N от 1 до k:");
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
