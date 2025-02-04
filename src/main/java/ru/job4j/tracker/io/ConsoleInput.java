package ru.job4j.tracker.io;

import ru.job4j.tracker.io.Input;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private Scanner sc;

    public ConsoleInput() {
        sc = new Scanner(System.in);
    }

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return sc.nextLine();
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
