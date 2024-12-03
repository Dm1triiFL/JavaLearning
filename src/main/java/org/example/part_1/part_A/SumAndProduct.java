package org.example.part_1.part_A;

public class SumAndProduct {
    public void calculate(String[] numbers) {
        int sum = 0;
        int product = 1;
        for (String num : numbers) {
            int number = Integer.parseInt(num);
            sum += number;
            product *= number;
        }
        System.out.println("Сумма: " + sum);
        System.out.println("Произведение: " + product);
    }
}