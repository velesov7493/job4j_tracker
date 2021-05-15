package ru.job4j.tracker.io;

import ru.job4j.tracker.io.Input;

public class StubInput implements Input {

    private String[] answers;
    private int position;

    public StubInput(String[] aAnswers) {
        answers = aAnswers;
    }

    @Override
    public String askStr(String question) {
        if (position >= answers.length) {
            position = 0;
        }
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
