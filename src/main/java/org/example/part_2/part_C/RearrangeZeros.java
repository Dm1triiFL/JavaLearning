package org.example.part_2.part_C;


public class RearrangeZeros {
    public void rearrangeZeros(int[][] matrix) {
        for (int[] row : matrix) {
            int count = 0;
            for (int value : row) {
                if (value != 0) {
                    row[count++] = value;
                }
            }
            while (count < row.length) {
                row[count++] = 0;
            }
        }
    }
}

