package org.example.part_9;

public class Main {
    public static void main(String[] args) {

        NumberProcessor processor = new NumberProcessor("C:\\Users\\dmshu\\IdeaProjects\\JavaLearning\\src\\main\\resources\\numbers.txt");


        try {
            processor.readFile();
            double totalSum = processor.calculateSum();
            double average = processor.calculateAverage();
            System.out.printf("Сумма: %.2f, Среднее: %.2f%n", totalSum, average);
        } catch (FileError | MemoryError e) {
            System.err.println(e.getMessage());
        } catch (InvalidValueError e) {
            System.err.println(e.getMessage());
            System.err.println("Некорректные значения были проигнорированы.");
        }
    }
}
