package org.example.part_3.part_B;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Шубин Дмитрий Б762-2 Вариант 2");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива комплексных чисел (n): ");
        int n = scanner.nextInt();
        Complex[] complexes = new Complex[n];

        // Ввод комплексных чисел
        for (int i = 0; i < n; i++) {
            System.out.print("Введите действительную часть комплексного числа " + (i + 1) + ": ");
            double real = scanner.nextDouble();
            System.out.print("Введите мнимую часть комплексного числа " + (i + 1) + ": ");
            double imaginary = scanner.nextDouble();
            complexes[i] = new Complex(real, imaginary);
        }

        // Выполнение операций
        Complex sum = ComplexOperations.add(complexes);
        Complex product = ComplexOperations.multiply(complexes);

        // Вывод результатов
        System.out.println("Сумма комплексных чисел: " + sum);
        System.out.println("Произведение комплексных чисел: " + product);

        scanner.close();
    }
}

