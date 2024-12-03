package org.example.part_1.part_B;
import java.util.*;

public class Numbs {
    public static void main(String[] args) {
        System.out.print("Шубин Дмитрий Б762-2 Вариант 12");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество целых чисел n: ");
        int n = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();
        System.out.println("Введите " + n + " целых чисел: ");

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        // 1. Четные и нечетные числа
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }
        }

        System.out.println("Четные числа: " + evenNumbers);
        System.out.println("Нечетные числа: " + oddNumbers);

        // 2. Наибольшее и наименьшее число
        int maxNumber = Collections.max(numbers);
        int minNumber = Collections.min(numbers);
        System.out.println("Наибольшее число: " + maxNumber);
        System.out.println("Наименьшее число: " + minNumber);

        // 3. Числа, которые делятся на 3 или на 9
        List<Integer> divisibleBy3Or9 = new ArrayList<>();
        for (int number : numbers) {
            if (number % 9 == 0 || number % 3 == 0) {
                divisibleBy3Or9.add(number);
            }
        }
        System.out.println("Числа, которые делятся на 3 или на 9: " + divisibleBy3Or9);

        // 4. Числа, которые делятся на 5 и на 7
        List<Integer> divisibleBy5And7 = new ArrayList<>();
        for (int number : numbers) {
            if (number % 5 == 0 && number % 7 == 0) {
                divisibleBy5And7.add(number);
            }
        }
        System.out.println("Числа, которые делятся на 5 и на 7: " + divisibleBy5And7);

        // 5. Трехзначные числа без одинаковых цифр
        List<Integer> threeDigitUnique = new ArrayList<>();
        for (int number : numbers) {
            if (number >= 100 && number < 1000) {
                String strNum = String.valueOf(number);
                if (strNum.charAt(0) != strNum.charAt(1) && strNum.charAt(0) != strNum.charAt(2) && strNum.charAt(1) != strNum.charAt(2)) {
                    threeDigitUnique.add(number);
                }
            }
        }
        System.out.println("Трехзначные числа без одинаковых цифр: " + threeDigitUnique);

        // 6. Простые числа
        List<Integer> primeNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (isPrime(number)) {
                primeNumbers.add(number);
            }
        }
        System.out.println("Простые числа: " + primeNumbers);

        // 7. Отсортированные числа в порядке возрастания и убывания
        List<Integer> sortedAsc = new ArrayList<>(numbers);
        List<Integer> sortedDesc = new ArrayList<>(numbers);
        Collections.sort(sortedAsc);
        Collections.sort(sortedDesc, Collections.reverseOrder());

        System.out.println("Числа в порядке возрастания: " + sortedAsc);
        System.out.println("Числа в порядке убывания: " + sortedDesc);

        // 8. Числа в порядке убывания частоты встречаемости
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int number : numbers) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> frequencyList = new ArrayList<>(frequencyMap.entrySet());
        frequencyList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("Числа в порядке убывания частоты встречаемости: ");
        for (Map.Entry<Integer, Integer> entry : frequencyList) {
            System.out.print(entry.getKey() + " ");
        }
        System.out.println();

        // 9. «Счастливые» числа
        List<Integer> happyNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (isHappy(number)) {
                happyNumbers.add(number);
            }
        }
        System.out.println("«Счастливые» числа: " + happyNumbers);

        // 10. Числа-палиндромы
        List<Integer> palindromicNumbers = new ArrayList<>();
        for (int number : numbers) {
            if (isPalindrome(number)) {
                palindromicNumbers.add(number);
            }
        }
        System.out.println("Числа-палиндромы: " + palindromicNumbers);

        // 11. Элементы, которые равны полусумме соседних элементов
        List<Integer> halfSumNeighbors = new ArrayList<>();
        for (int i = 1; i < numbers.size() - 1; i++) {
            int left = numbers.get(i - 1);
            int right = numbers.get(i + 1);
            if (numbers.get(i) == (left + right) / 2) {
                halfSumNeighbors.add(numbers.get(i));
            }
        }
        System.out.println("Элементы, которые равны полусумме соседних элементов: " + halfSumNeighbors);

        scanner.close();
    }

    // Метод для проверки простого числа
    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // Метод для проверки "счастливого" числа
    private static boolean isHappy(int num) {
        Set<Integer> seen = new HashSet<>();
        while (num != 1 && !seen.contains(num)) {
            seen.add(num);
            int sum = 0;
            while (num > 0) {
                int digit = num % 10;
                sum += digit * digit;
                num /= 10;
            }
            num = sum;
        }
        return num == 1;
    }

    // Метод для проверки палиндрома
    private static boolean isPalindrome(int number) {
        String strNum = String.valueOf(number);
        String revStrNum = new StringBuilder(strNum).reverse().toString();
        return strNum.equals(revStrNum);
    }
}
