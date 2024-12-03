package org.example.part_2.part_B;


public class FindBase {
    public void findBase(int decimalNumber, String representation) {
        int base = 0;

        for (int i = 2; i <= 36; i++) {  // допустимые основания от 2 до 36
            if (Integer.toString(decimalNumber, i).equals(representation)) {
                base = i;
                break;
            }
        }

        if (base > 0) {
            System.out.println("Основание системы счисления: " + base);
        } else {
            System.out.println("Не найдено основание, соответствующее представлению " + representation);
        }
    }
}
