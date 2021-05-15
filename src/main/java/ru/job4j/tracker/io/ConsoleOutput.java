package ru.job4j.tracker.io;

import ru.job4j.tracker.io.Output;

public class ConsoleOutput implements Output {

    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
}
