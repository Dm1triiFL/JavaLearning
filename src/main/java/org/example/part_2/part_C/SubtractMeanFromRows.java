package org.example.part_2.part_C;



public class SubtractMeanFromRows {
    public void subtractMean(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            double sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
            double mean = sum / matrix[i].length;
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] -= mean;
            }
        }
    }
}
