package org.example.part_2.part_C;


import java.util.Arrays;

public class SumSortRows {
    public void sortRowsBySum(int[][] matrix) {
        Arrays.sort(matrix, (a, b) -> Integer.compare(Arrays.stream(a).sum(), Arrays.stream(b).sum()));
    }
}
