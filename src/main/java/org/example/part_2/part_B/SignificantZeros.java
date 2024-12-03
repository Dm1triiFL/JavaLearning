package org.example.part_2.part_B;

public class SignificantZeros {
    public void countSignificantZeros(int number) {
        String binary = Integer.toBinaryString(number);
        int count = 0;
        for (char c : binary.toCharArray()) {
            if (c == '0') {
                count++;
            }
        }
        System.out.println("Количество значащих нулей в двоичной записи числа " + number + ": " + count);
    }
}
