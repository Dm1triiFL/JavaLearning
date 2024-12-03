package org.example.part_2.part_B;


public class DivisibleByThree {
    public void printNumbers() {
        System.out.println("Числа от 1 до 100, которые делятся на 3 без остатка:");
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
