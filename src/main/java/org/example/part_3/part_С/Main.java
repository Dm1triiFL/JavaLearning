package org.example.part_3.part_С;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Шубин Дмитрий Б762-2 Вариант 12");
        Scanner scanner = new Scanner(System.in);

        // Создание массива векторов
        Vector[] vectors = new Vector[2];

        // Ввод векторов
        for (int i = 0; i < vectors.length; i++) {
            System.out.println("Введите координаты вектора " + (i + 1) + " (x и y):");
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            vectors[i] = new Vector(x, y);
        }

        // Вычисление и вывод свойств векторов
        System.out.println("Вектор 1: " + vectors[0]);
        System.out.println("Вектор 2: " + vectors[1]);
        System.out.println("Модуль вектора 1: " + vectors[0].magnitude());
        System.out.println("Модуль вектора 2: " + vectors[1].magnitude());
        System.out.println("Скалярное произведение: " + vectors[0].dotProduct(vectors[1]));
        System.out.println("Сложение: " + vectors[0].add(vectors[1]));
        System.out.println("Вычитание: " + vectors[0].subtract(vectors[1]));

        // Проверка коллинеарности и ортогональности
        if (vectors[0].isCollinear(vectors[1])) {
            System.out.println("Векторы коллинеарны.");
        } else {
            System.out.println("Векторы не коллинеарны.");
        }

        if (vectors[0].isOrthogonal(vectors[1])) {
            System.out.println("Векторы ортогональны.");
        } else {
            System.out.println("Векторы не ортогональны.");
        }

        scanner.close();
    }
}

