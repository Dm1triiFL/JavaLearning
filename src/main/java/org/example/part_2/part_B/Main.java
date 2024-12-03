package org.example.part_2.part_B;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Шубин Дмитрий Б762-2 Вариант 12");
        // Задание 1: Вывести на экран таблицу умножения
        MultiplicationTable multiplicationTable = new MultiplicationTable();
        multiplicationTable.printTable();

        // Задание 2: Вывести элементы массива в обратном порядке
        ReverseArray reverseArray = new ReverseArray();
        int[] sampleArray = {1, 2, 3, 4, 5};
        reverseArray.reverseArray(sampleArray);

        // Задание 3: Определить принадлежность некоторого значения k интервалам (n, m], [n, m), (n, m), [n, m].
        IntervalCheck intervalCheck = new IntervalCheck();
        intervalCheck.checkValueInIntervals(5, 2, 10);

        // Задание 4: Вывести на экран все числа от 1 до 100, которые делятся на 3 без остатка.
        DivisibleByThree divisibleByThree = new DivisibleByThree();
        divisibleByThree.printNumbers();

        // Задание 5: Сколько значащих нулей в двоичной записи числа 129?
        SignificantZeros significantZeros = new SignificantZeros();
        significantZeros.countSignificantZeros(129);

        // Задание 6: Найти основание, в котором число 81 записывается как 100.
        FindBase findBase = new FindBase();
        findBase.findBase(81, "100");

        // Задание 7: Перевод числа из десятичной системы в любую другую.
        DecimalToAnyBase decimalToAnyBase = new DecimalToAnyBase();
        System.out.println("Число 81 в двоичной системе: " + decimalToAnyBase.convertDecimalToAnyBase(81, 2));

        // Задание 8: Перевод числа из одной числовой системы в другую.
        AnyBaseToAnyBase anyBaseToAnyBase = new AnyBaseToAnyBase();
        System.out.println("Число 101 в двоичной системе в десятичной: " + anyBaseToAnyBase.convert("101", 2, 10));

        // Задание 9: Ввести число от 1 до 12 и вывести название месяца.
        MonthName monthName = new MonthName();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите номер месяца (от 1 до 12): ");
        int monthNumber = scanner.nextInt();
        monthName.printMonthName(monthNumber);

        scanner.close();
    }
}
