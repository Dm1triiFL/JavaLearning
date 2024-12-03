package org.example.part_2.part_C;


import java.util.Arrays;

public class SortRowsColumns {
    public void sortRows(int[][] matrix, int k) {
        Arrays.sort(matrix, (a, b) -> Integer.compare(a[k], b[k]));
    }

    public void sortColumns(int[][] matrix, int k) {
        int n = matrix.length;
        int[] column = new int[n];
        for (int i = 0; i < n; i++) {
            column[i] = matrix[i][k];
        }
        Arrays.sort(column);
        for (int i = 0; i < n; i++) {
            matrix[i][k] = column[i];
        }
    }
}
