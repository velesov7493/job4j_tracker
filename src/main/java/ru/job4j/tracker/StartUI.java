package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        Item item1 = new Item();
        String dateTimeStr = item1.getCreated().format(formatter);
        System.out.println("Время создания объекта item1: " + dateTimeStr);
    }
}
