package org.example.part_2.part_B;

public class ReverseArray {
    public void reverseArray(int[] array) {
        System.out.print("Элементы массива в обратном порядке: ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
