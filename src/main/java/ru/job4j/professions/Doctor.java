package ru.job4j.professions;

import java.util.Date;

public class Doctor extends Profession {

    private int[] workDays;

    public Doctor(String aName, String aSurname, String aEducation, Date aBirthday, int[] aWorkDays) {
        super(aName, aSurname, aEducation, aBirthday);
        workDays = aWorkDays;
    }

    public Diagnosis heal(Pacient pacient, Diagnosis previousDiagnosis) {
        return new Diagnosis();
    }

    public Diagnosis examination(Pacient pacient) {
        return new Diagnosis();
    }

    public int[] getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int[] workDays) {
        this.workDays = workDays;
    }
}
