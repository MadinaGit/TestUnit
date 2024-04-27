package ru.netology;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordChecker pass = new PasswordChecker();
        System.out.println("Введите минимальную длину пароля: ");

        try {
            int minLenght = Integer.parseInt(scanner.nextLine());
            pass.setMinLenght(minLenght);
        } catch (IllegalArgumentException e) {
            System.out.println("Неверное значение");
            return;
        }

        System.out.println("Введите макс. допустимое количество повторений символов подряд:  ");

        try {
            int maxRepeats = Integer.parseInt(scanner.nextLine());
            pass.setMaxRepeats(maxRepeats);
        } catch (IllegalArgumentException e) {
            System.out.println("Неверное значение");
            return;
        }
        while (true) {
            System.out.println("Введите пароль или end: ");
            String password = scanner.nextLine();

            if ("end".equals(password)) {
                System.out.println("Программа завершена");
                break;
            }

            System.out.println(pass.verify(password) ? "Походит" : "Не подходит");
        }

    }
}
