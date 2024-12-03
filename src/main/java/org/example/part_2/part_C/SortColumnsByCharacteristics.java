package org.example.part_2.part_C;


import java.util.Arrays;
import java.util.Comparator;

public class SortColumnsByCharacteristics {
    public void sortColumnsByCharacteristics(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Создаем массив для характеристик столбцов
        int[] columnCharacteristics = new int[m];

        // Вычисляем характеристики для каждого столбца
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                columnCharacteristics[j] += Math.abs(matrix[i][j]);
            }
        }

        // Создаем массив индексов для сортировки
        Integer[] indices = new Integer[m];
        for (int j = 0; j < m; j++) {
            indices[j] = j;
        }

        // Сортируем индексы по характеристикам в порядке убывания
        Arrays.sort(indices, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return Integer.compare(columnCharacteristics[b], columnCharacteristics[a]);
            }
        });

        // Создаем новую матрицу с отсортированными столбцами
        int[][] sortedMatrix = new int[n][m];
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                sortedMatrix[i][j] = matrix[i][indices[j]];
            }
        }

        // Копируем отсортированную матрицу обратно в исходную
        for (int i = 0; i < n; i++) {
            System.arraycopy(sortedMatrix[i], 0, matrix[i], 0, m);
        }
    }
}
