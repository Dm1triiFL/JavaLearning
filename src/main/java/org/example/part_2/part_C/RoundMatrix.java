package org.example.part_2.part_C;


public class RoundMatrix {
    public void roundMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.round(matrix[i][j]);
            }
        }
    }
}
