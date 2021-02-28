package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        String rsl = "Может быть";
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String question = input.nextLine();
        int answer = new Random().nextInt(3);
        if (answer == 0) {
            rsl = "Да";
        } else if (answer == 1) {
            rsl = "Нет";
        }
        System.out.println(rsl);
    }
}
