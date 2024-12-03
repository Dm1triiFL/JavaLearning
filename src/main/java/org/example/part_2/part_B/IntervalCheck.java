package org.example.part_2.part_B;


public class IntervalCheck {
    public void checkValueInIntervals(int k, int n, int m) {
        System.out.println("Проверка принадлежности числа " + k + " интервалам:");
        System.out.println("(n, m]: " + (k > n && k <= m));
        System.out.println("[n, m): " + (k >= n && k < m));
        System.out.println("(n, m): " + (k > n && k < m));
        System.out.println("[n, m]: " + (k >= n && k <= m));
    }
}
