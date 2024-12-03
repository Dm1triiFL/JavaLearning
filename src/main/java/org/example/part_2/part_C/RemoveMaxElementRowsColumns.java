package org.example.part_2.part_C;


public class RemoveMaxElementRowsColumns {
    public int[][] removeMaxElementRowsColumns(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        int row = -1, col = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    row = i;
                    col = j;
                }
            }
        }

        if (row == -1 || col == -1) return matrix;

        boolean[] toRemoveRows = new boolean[matrix.length];
        boolean[] toRemoveCols = new boolean[matrix[0].length];
        toRemoveRows[row] = true;
        toRemoveCols[col] = true;

        int newRows = 0;
        int newCols = 0;

        for (boolean remove : toRemoveRows) {
            if (!remove) newRows++;
        }
        for (boolean remove : toRemoveCols) {
            if (!remove) newCols++;
        }

        int[][] newMatrix = new int[newRows][newCols];
        int newRow = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (toRemoveRows[i]) continue;
            int newCol = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (toRemoveCols[j]) continue;
                newMatrix[newRow][newCol++] = matrix[i][j];
            }
            newRow++;
        }
        return newMatrix;
    }
}
