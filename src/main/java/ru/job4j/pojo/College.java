package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class College {

    public static void main(String[] args) {
        Student vasya = new Student();
        vasya.setName("Васильев Василий Васильевич");
        vasya.setGroup(10);
        vasya.setAdmissionDate(LocalDate.now());
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("Студент: " + vasya.getName());
        System.out.println("Группа: " + vasya.getGroup());
        System.out.println("Дата поступления: " + vasya.getAdmissionDate().format(f));
    }
}
