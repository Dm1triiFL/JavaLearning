package org.example.part_7;

//"Шубин Дмитрий Б762-2 Вариант 12");

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayProcessor {
    private int[] arr;

    public ArrayProcessor(int[] arr) {
        this.arr = arr;
    }

    public int[] removeEvensAndFillWithZeros() {
        List<Integer> filteredList = Arrays.stream(arr)
                .filter(num -> num % 2 != 0)
                .boxed()
                .collect(Collectors.toList());


        int zerosToAdd = arr.length - filteredList.size();
        for (int i = 0; i < zerosToAdd; i++) {
            filteredList.add(0);
        }



        return filteredList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
