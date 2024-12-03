package org.example.part_7;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrayProcessorTest {

    @Test
    public void testRemoveEvensAndFillWithZeros() {
        // Исходный массив
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] expectedArray = {1, 3, 5, 7, 9, 0, 0, 0, 0};

        // Создаем объект ArrayProcessor
        ArrayProcessor processor = new ArrayProcessor(inputArray);
        int[] resultArray = processor.removeEvensAndFillWithZeros();

        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    public void testEmptyArray() {
        // Тест для пустого массива
        int[] inputArray = {};
        int[] expectedArray = {};

        ArrayProcessor processor = new ArrayProcessor(inputArray);
        int[] resultArray = processor.removeEvensAndFillWithZeros();

        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    public void testArrayWithNoEvens() {
        // Тест для массива, не содержащего четных чисел
        int[] inputArray = {1, 3, 5};
        int[] expectedArray = {1, 3, 5}; // Ожидается такой же массив

        ArrayProcessor processor = new ArrayProcessor(inputArray);
        int[] resultArray = processor.removeEvensAndFillWithZeros();

        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    public void testArrayWithAllEvens() {
        // Тест для массива, содержащего только четные числа
        int[] inputArray = {2, 4, 6, 8};
        int[] expectedArray = {0, 0, 0, 0}; // Ожидается массив, заполненный нулями

        ArrayProcessor processor = new ArrayProcessor(inputArray);
        int[] resultArray = processor.removeEvensAndFillWithZeros();

        assertArrayEquals(expectedArray, resultArray);
    }
}
