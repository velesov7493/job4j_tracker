package ru.job4j.oop;

public class College {

    public static void main(String[] args) {
        Freshman fedor1 = new Freshman();
        fedor1.song();
        Student fedor2 = fedor1;
        fedor2.song();
        Object obj = fedor2;
        System.out.println(obj);
    }
}
