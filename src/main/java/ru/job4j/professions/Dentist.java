package ru.job4j.professions;

import java.util.Date;

public class Dentist extends Doctor {

    private boolean privatePractice;

    public Dentist(String aName, String aSurname, String aEducation, Date aBirthday, int[] aWorkDays, boolean aPrivatePractice) {
        super(aName, aSurname, aEducation, aBirthday, aWorkDays);
        privatePractice = aPrivatePractice;
    }

    public void pullOutTooth(Pacient pacient) {}
    public void insertTooth(Pacient pacient, ToothType toothType) {}

    public boolean isPrivatePractice() {
        return privatePractice;
    }

    public void setPrivatePractice(boolean privatePractice) {
        this.privatePractice = privatePractice;
    }
}
