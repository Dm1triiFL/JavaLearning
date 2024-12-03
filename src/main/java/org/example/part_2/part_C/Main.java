package org.example.part_2.part_C;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Ввод n-размерности матрицы
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размерность матрицы n: ");
        int n = scanner.nextInt();

        // Генерация матрицы
        int[][] matrix = MatrixGenerator.generateMatrix(n);

        // Вывод начальной матрицы
        System.out.println("Изначальная матрица:");
        printMatrix(matrix);

        // Задание 1: Упорядочить строки (по k-му столбцу)
        SortRowsColumns sortRowsColumns = new SortRowsColumns();
        System.out.print("Введите номер столбца для сортировки: ");
        int k = scanner.nextInt();
        sortRowsColumns.sortRows(matrix, k - 1); // Приводим к индексации с нуля
        System.out.println("Матрица после сортировки строк по столбцу " + k + ":");
        printMatrix(matrix);

        // Задание 2: Циклический сдвиг на k позиций вправо
        CyclicShift cyclicShift = new CyclicShift();
        System.out.print("Введите количество позиций для сдвига: ");
        int positions = scanner.nextInt();
        cyclicShift.shiftRight(matrix, positions); // Сдвиг вправо
        System.out.println("Матрица после циклического сдвига вправо на " + positions + ":");
        printMatrix(matrix);

        // Задание 3: Наибольшее число возрастающих/убывающих элементов
        MaximumConsecutiveElements maxConsecutive = new MaximumConsecutiveElements();
        int maxCount = maxConsecutive.findMaxConsecutive(matrix);
        System.out.println("Максимальное количество подряд идущих элементов: " + maxCount);

        // Задание 4: Сумма элементов между первым и вторым положительными элементами
        SumBetweenPositive sumBetweenPositive = new SumBetweenPositive();
        sumBetweenPositive.sumElementsBetweenPositive(matrix);

        // Задание 5: Числа от 1 до k в виде матрицы N x N
        PrintMatrixNumbers printMatrixNumbers = new PrintMatrixNumbers();
        printMatrixNumbers.printMatrix(n);

        // Задание 6: Округлить все элементы матрицы
        RoundMatrix roundMatrix = new RoundMatrix();
        double[][] doubleMatrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                doubleMatrix[i][j] = Math.random() * 100;
            }
        }
        roundMatrix.roundMatrix(doubleMatrix);
        System.out.println("Матрица после округления элементов:");
        for (double[] row : doubleMatrix) {
            for (double num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        // Задание 7: Повернуть матрицу на 90, 180 или 270 градусов
        RotateMatrix rotateMatrix = new RotateMatrix();
        System.out.println("Матрица после поворота на 90 градусов:");
        doubleMatrix = rotateMatrix.rotate90Degrees(doubleMatrix);
        printDoubleMatrix(doubleMatrix);

        // Задание 8: Определитель матрицы
        Determinant determinant = new Determinant();
        double det = determinant.calculateDeterminant(doubleMatrix);
        System.out.println("Определитель матрицы: " + det);

        // Задание 9: Вычитание среднего арифметического
        SubtractMeanFromRows subtractMean = new SubtractMeanFromRows();
        subtractMean.subtractMean(matrix);
        System.out.println("Матрица после вычитания среднего арифметического из каждой строки:");
        printMatrix(matrix);

        // Задание 10: Удаление строк и столбцов с максимальными элементами
        RemoveMaxElementRowsColumns removeMax = new RemoveMaxElementRowsColumns();
        int[][] reducedMatrix = removeMax.removeMaxElementRowsColumns(matrix);
        System.out.println("Матрица после удаления строк и столбцов с максимальными элементами:");
        printMatrix(reducedMatrix);

        // Задание 11: Уплотнение матрицы, удаление строк и столбцов с нулями
        CompactMatrix compactMatrix = new CompactMatrix();
        int[][] compactedMatrix = compactMatrix.compact(matrix);
        System.out.println("Матрица после уплотнения (удаление строк и столбцов с нулями):");
        printMatrix(compactedMatrix);

        // Задание 12: Перемещение минимального элемента на заданную позицию
        MoveMinElement moveMinElement = new MoveMinElement();
        System.out.print("Введите позицию для перемещения минимального элемента (row, col): ");
        int targetRow = scanner.nextInt();
        int targetCol = scanner.nextInt();
        moveMinElement.moveMinToGivenPosition(matrix, targetRow - 1, targetCol - 1);
        System.out.println("Матрица после перемещения минимального элемента на позицию (" + targetRow + ", " + targetCol + "):");
        printMatrix(matrix);

        // Задание 13: Перемещение нулей в конце
        RearrangeZeros rearrangeZeros = new RearrangeZeros();
        rearrangeZeros.rearrangeZeros(matrix);
        System.out.println("Матрица после перемещения нулей в конце строк:");
        printMatrix(matrix);

        // Задание 14: Количество седловых точек
        SaddlePoints saddlePoints = new SaddlePoints();
        saddlePoints.countSaddlePoints(matrix);

        // Задание 15: Упорядочивание строк по сумме
        SumSortRows sumSortRows = new SumSortRows();
        sumSortRows.sortRowsBySum(matrix);
        System.out.println("Матрица после упорядочивания строк по сумме элементов:");
        printMatrix(matrix);

        // Задание 16: Локальные минимумы
        LocalMinima localMinima = new LocalMinima();
        int localMinimaCount = localMinima.countLocalMinima(matrix);
        System.out.println("Количество локальных минимумов: " + localMinimaCount);

        // Задание 17: Наименьший из локальных максимумов
        MinOfLocalMaxima minOfLocalMaxima = new MinOfLocalMaxima();
        Integer minLocalMax = minOfLocalMaxima.findMinOfLocalMaxima(matrix);
        System.out.println("Наименьший из локальных максимумов: " + (minLocalMax != null ? minLocalMax : "Нет локальных максимумов"));

        // Задание 18: Упорядочивание столбцов
        SortColumnsByCharacteristics sortColumns = new SortColumnsByCharacteristics();
        sortColumns.sortColumnsByCharacteristics(matrix);
        System.out.println("Матрица после упорядочивания столбцов по характеристикам:");
        printMatrix(matrix);

        // Задание 19: Перестановка элементами матрицы
        RearrangeMaxToDiagonal rearrangeMaxToDiagonal = new RearrangeMaxToDiagonal();
        rearrangeMaxToDiagonal.rearrangeToDiagonal(doubleMatrix);
        System.out.println("Матрица после перемещения максимальных элементов на главную диагональ:");
        for (double[] row : doubleMatrix) {
            for (double num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    // Метод для вывода целочисленной матрицы
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    // Метод для вывода матрицы с плавающей запятой
    private static void printDoubleMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double num : row) {
                System.out.printf("%.2f ", num);  // Округление до 2 знаков после запятой
            }
            System.out.println();
        }
    }
}
