package org.example.part_9;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NumberProcessor {
    private final String filename;
    final List<Double> numbers;

    public NumberProcessor(String filename) {
        this.filename = filename;
        this.numbers = new ArrayList<>();
    }

    public void readFile() throws FileError, MemoryError {
        List<String> invalidMessages = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 2) {
                    System.err.println("Некорректная строка: " + line);
                    continue;
                }
                String numberStr = parts[0];
                String locale = parts[1];
                try {
                    processNumber(numberStr, locale);
                    System.out.println("Добавлено число: " + numberStr);
                } catch (InvalidValueError e) {
                    invalidMessages.add(e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileError("Файл '" + filename + "' не найден.");
        } catch (IOException e) {
            throw new FileError("Ошибка чтения файла.");
        } catch (OutOfMemoryError e) {
            throw new MemoryError("Ошибка: недостаточно памяти для создания и хранения чисел.");
        }

        if (!invalidMessages.isEmpty()) {
            System.err.println("Некорректные значения были проигнорированы:");
            for (String message : invalidMessages) {
                System.err.println(message);
            }
        }
    }

    void processNumber(String numberStr, String localeStr) throws InvalidValueError,MemoryError {
        double number;

        Locale locale;
        switch (localeStr.toLowerCase()) {
            case "fr":
                locale = Locale.FRENCH;
                numberStr = numberStr.replace(',', '.');
                break;
            case "en":
                locale = Locale.ENGLISH;
                break;
            default:
                throw new InvalidValueError("Неподдерживаемая локаль: " + localeStr);
        }

        try {
            NumberFormat numberFormat = NumberFormat.getInstance(locale);
            number = numberFormat.parse(numberStr).doubleValue();
        } catch (ParseException e) {
            throw new InvalidValueError("Некорректная запись числа: " + numberStr);
        }

        if (number < -10000 || number > 10000) {
            throw new InvalidValueError("Недопустимое значение: " + number);
        }

        try {
            numbers.add(number);
        } catch (OutOfMemoryError e) {
            throw new MemoryError("Ошибка: недостаточно памяти для добавления числа: " + numberStr);
        }
    }

    public double calculateSum() throws MemoryError {
        try {
            return numbers.stream().mapToDouble(Double::doubleValue).sum();
        } catch (OutOfMemoryError e) {
            throw new MemoryError("Ошибка: недостаточно памяти для вычисления суммы чисел.");
        }
    }

    public double calculateAverage() throws InvalidValueError, MemoryError {
        if (numbers.isEmpty()) {
            throw new InvalidValueError("Нет чисел для вычисления.");
        }
        return calculateSum() / numbers.size();
    }
}
