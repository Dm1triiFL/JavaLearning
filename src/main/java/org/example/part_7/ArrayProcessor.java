package org.example.part_7;

//"Шубин Дмитрий Б762-2 Вариант 12");
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

public class ArrayProcessor {
    private int[] arr;

    public ArrayProcessor(int[] arr) {
        this.arr = arr;
    }

    public int[] removeEvensAndFillWithZeros() {
        int[] result = new int[arr.length];
        final int[] index = {0};

        IntPredicate isEven = num -> num % 2 == 0;


        for (int num : arr) {
            if (!isEven.test(num)) {
                result[index[0]++] = num;
            }
        }

        return result;
    }
}
