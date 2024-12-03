package org.example.part_2.part_C;


public class SaddlePoints {
    public void countSaddlePoints(int[][] matrix) {
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                boolean minInRow = true;
                boolean maxInCol = true;

                for (int k = 0; k < matrix[i].length; k++) {
                    if (matrix[i][k] < matrix[i][j]) {
                        minInRow = false;
                        break;
                    }
                }

                for (int k = 0; k < matrix.length; k++) {
                    if (matrix[k][j] > matrix[i][j]) {
                        maxInCol = false;
                        break;
                    }
                }

                if (minInRow && maxInCol) {
                    count++;
                }
            }
        }
        System.out.println("Количество седловых точек: " + count);
    }
}
