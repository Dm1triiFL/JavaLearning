package org.example.part_2.part_C;


public class LocalMinima {
    public int countLocalMinima(int[][] matrix) {
        int count = 0;
        int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1}; // Вверх, вниз, влево, вправо и диагонали
        int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                boolean isLocalMin = true;
                for (int d = 0; d < dx.length; d++) {
                    int ni = i + dx[d];
                    int nj = j + dy[d];
                    if (ni >= 0 && ni < matrix.length && nj >= 0 && nj < matrix[i].length && matrix[ni][nj] <= matrix[i][j]) {
                        isLocalMin = false;
                        break;
                    }
                }
                if (isLocalMin) {
                    count++;
                }
            }
        }
        return count;
    }
}
