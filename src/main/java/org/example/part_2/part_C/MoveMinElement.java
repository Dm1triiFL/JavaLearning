package org.example.part_2.part_C;


public class MoveMinElement {
    public void moveMinToGivenPosition(int[][] matrix, int targetRow, int targetCol) {
        int min = Integer.MAX_VALUE;
        int minRow = -1;
        int minCol = -1;

        // Find minimum element
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                    minRow = i;
                    minCol = j;
                }
            }
        }

        // Swap
        if (minRow != -1 && minCol != -1) {
            matrix[minRow][minCol] = matrix[targetRow][targetCol];
            matrix[targetRow][targetCol] = min;
        }
    }
}

