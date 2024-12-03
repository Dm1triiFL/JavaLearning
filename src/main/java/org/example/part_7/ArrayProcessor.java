package org.example.part_7;

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

        IntConsumer fillWithZeros = i -> {
            while (index[0] < result.length) {
                result[index[0]++] = 0;
            }
        };

        fillWithZeros.accept(0);

        return result;
    }
}
