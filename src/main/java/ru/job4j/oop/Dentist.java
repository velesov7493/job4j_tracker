package ru.job4j.oop;

public class Dentist extends Doctor {

    public static enum ToothType {
        Ceramic,
        Gold,
        Silver
    }

    private boolean privatePractice;

    public void pullOutTooth(Pacient pacient) {}
    public void insertTooth(Pacient pacient, ToothType toothType) {}

    public boolean isPrivatePractice() {
        return privatePractice;
    }

    public void setPrivatePractice(boolean privatePractice) {
        this.privatePractice = privatePractice;
    }
}
