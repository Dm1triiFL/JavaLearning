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
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 2) {
                    throw new InvalidValueError("Некорректная строка: " + line);
                }
                String numberStr = parts[0];
                String locale = parts[1];
                try {
                    processNumber(numberStr, locale);
                } catch (InvalidValueError e) {
                    throw new InvalidValueError(e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            throw new FileError("Файл '" + filename + "' не найден.");
        } catch (IOException e) {
            throw new MemoryError("Ошибка чтения файла. Недостаточно памяти или другие проблемы.");
        }
    }


    void processNumber(String numberStr, String localeStr) throws InvalidValueError {
        double number;

        Locale locale;
        switch (localeStr.toLowerCase()) {
            case "fr":
                locale = Locale.FRENCH; // Французская локаль
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

        numbers.add(number);
    }

    public double calculateSum() {
        return numbers.stream().mapToDouble(Double::doubleValue).sum();
    }


    public double calculateAverage() throws InvalidValueError {
        if (numbers.isEmpty()) {
            throw new InvalidValueError("Нет чисел для вычисления.");
        }
        return calculateSum() / numbers.size();
    }
}
