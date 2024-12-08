package org.example.part_9;

public class Main {
    public static void main(String[] args) {
        String filename = "src\\main\\resources\\part_9\\numbers.txt";
        NumberProcessor processor = new NumberProcessor(filename);

        try {
            processor.readFile();
            double totalSum = processor.calculateSum();
            double average = processor.calculateAverage();
            System.out.printf("Сумма: %.2f, Среднее: %.2f%n", totalSum, average);
        } catch (FileError e) {
            System.err.println("Ошибка файла: " + e.getMessage());
        } catch (MemoryError e) {
            System.err.println("Ошибка памяти: " + e.getMessage());
        } catch (InvalidValueError e) {
            System.err.println("Ошибка значения: " + e.getMessage());
            System.err.println("Некорректные значения были проигнорированы.");
        }
    }
}
