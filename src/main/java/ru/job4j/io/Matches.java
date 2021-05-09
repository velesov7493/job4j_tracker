package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            int canTake = Math.min(3, count);
            System.out.println("Осталось & Можно взять : " + count + " & " + canTake + " спичек.");
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.print("[" + player + "] сколько взять?: ");
            int matches = Integer.parseInt(input.nextLine());
            if (matches < 1 || matches > canTake) {
                continue;
            }
            count -= matches;
            turn = !turn;
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
