package org.example.part_1.part_A;

public class Main {
    public static void main(String[] args) {
        System.out.print("Шубин Дмитрий Б762-2 Вариант 12");
        // 1 Приветствие пользователя
        Greeting greeting = new Greeting();
        if (args.length > 0) {
            greeting.greet(args[0]);
        }

        // 2 Отображение аргументов в обратном порядке
        ReverseArgs reverseArgs = new ReverseArgs();
        reverseArgs.displayReversedArgs(args);

        // 3 Генерация случайных чисел
        RandomNumbers randomNumbers = new RandomNumbers();
        randomNumbers.printRandomNumbers(5, true);
        randomNumbers.printRandomNumbers(5, false);

        // 4 Проверка пароля
        PasswordCheck passwordCheck = new PasswordCheck();
        String inputPassword = args.length > 0 ? args[0] : "";
        String samplePassword = "123";
        if (passwordCheck.checkPassword(inputPassword, samplePassword)) {
            System.out.println("Пароль верный.");
        } else {
            System.out.println("Пароль неверный.");
        }

        // 5 Сумма и произведение
        SumAndProduct sumAndProduct = new SumAndProduct();
        sumAndProduct.calculate(args);

        // 6 Информация о разработчике
        DeveloperInfo developerInfo = new DeveloperInfo();
        developerInfo.displayInfo();
    }
}
