package ru.job4j.professions;

public class Doctor extends Profession {

    private int[] workDays;

    public Doctor(int[] aWorkDays) {
        super();
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
