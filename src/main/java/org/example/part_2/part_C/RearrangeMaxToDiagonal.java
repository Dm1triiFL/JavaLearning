package org.example.part_2.part_C;


import java.util.Arrays;

public class RearrangeMaxToDiagonal {
    public void rearrangeToDiagonal(double[][] matrix) {
        int n = matrix.length;

        double[] elements = new double[n * n];
        int index = 0;

        // Сканируем все элементы матрицы
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                elements[index++] = matrix[i][j];
            }
        }

        // Сортируем элементы в порядке убывания
        Arrays.sort(elements);
        for (int i = 0; i < elements.length / 2; i++) {
            double temp = elements[i];
            elements[i] = elements[elements.length - 1 - i];
            elements[elements.length - 1 - i] = temp;
        }

        // Заполняем диагональ
        index = 0;
        for (int i = 0; i < n; i++) {
            matrix[i][i] = elements[index++];
        }
    }
}
