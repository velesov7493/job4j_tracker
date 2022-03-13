package ru.job4j.professions;

import java.util.Date;

public class Dentist extends Doctor {

    private boolean privatePractice;

    public Dentist(int[] aWorkDays, boolean aPrivatePractice) {
        super(aWorkDays);
        privatePractice = aPrivatePractice;
    }

    public void pullOutTooth(Pacient pacient) {
    }

    public void insertTooth(Pacient pacient, ToothType toothType) {
    }

    public boolean isPrivatePractice() {
        return privatePractice;
    }

    public void setPrivatePractice(boolean privatePractice) {
        this.privatePractice = privatePractice;
    }
}
