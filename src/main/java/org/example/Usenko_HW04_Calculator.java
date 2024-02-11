package org.example;

import java.util.List;
import java.util.Scanner;

public class Usenko_HW04_Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть перше число:");
        String number1 = scanner.nextLine();

        System.out.println("Введіть операцію (PLUS, MINUS, MULTIPLICATION, DIVISION, REMAINDER):");
        String operation = scanner.nextLine();

        System.out.println("Введіть друге число:");
        String number2 = scanner.nextLine();

        List<String> inputList = List.of(number1, operation, number2);

        Usenko_HW04_Calculator usenkoHW04Calculator = new Usenko_HW04_Calculator();
        Integer result = usenkoHW04Calculator.calculate(inputList);

        if (result != null) {
            System.out.println("Результат: " + result);
        } else {
            System.out.println("Неправильна операція або ділення на нуль.");
        }
    }

    public Integer calculate(List<String> list) {
        if (list.size() != 3) {
            System.out.println("Неправильний розмір введення.");
            return null;
        }

        try {
            int a = Integer.parseInt(list.get(0));
            Usenko_HW04_Operations operation = Usenko_HW04_Operations.valueOf(list.get(1));
            int b = Integer.parseInt(list.get(2));

            switch (operation) {
                case PLUS:
                    return a + b;
                case MINUS:
                    return a - b;
                case MULTIPLICATION:
                    return a * b;
                case DIVISION:
                    if (b != 0) {
                        return a / b;
                    } else {
                        System.out.println("Ділення на нуль.");
                        return null;
                    }
                case REMAINDER:
                    if (b != 0) {
                        return a % b;
                    } else {
                        System.out.println("Ділення на нуль для...");
                        return null;
                    }
                default:
                    System.out.println("Непідтримувана операція.");
                    return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Недійсний формат числа.");
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println("Недійсна операція.");
            return null;
        }
    }
}