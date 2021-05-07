package ru.job4j.oop;

public class Doctor extends Profession {

    private int[] workDays;

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
