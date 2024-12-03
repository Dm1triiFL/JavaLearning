package org.example.part_2.part_C;


public class CompactMatrix {
    public int[][] compact(int[][] matrix) {
        boolean[] nonZeroRows = new boolean[matrix.length];
        boolean[] nonZeroCols = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    nonZeroRows[i] = true;
                    nonZeroCols[j] = true;
                }
            }
        }

        int newRows = 0;
        int newCols = 0;

        for (boolean row : nonZeroRows) if (row) newRows++;
        for (boolean col : nonZeroCols) if (col) newCols++;

        int[][] newMatrix = new int[newRows][newCols];
        int rowIndex = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (!nonZeroRows[i]) continue;
            int colIndex = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (!nonZeroCols[j]) continue;
                newMatrix[rowIndex][colIndex++] = matrix[i][j];
            }
            rowIndex++;
        }
        return newMatrix;
    }
}
