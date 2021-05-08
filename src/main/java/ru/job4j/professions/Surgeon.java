package ru.job4j.professions;

import java.util.Date;

public class Surgeon extends Doctor {

    private String category;

    public Surgeon(int[] aWorkDays, String aCategory) {
        super(aWorkDays);
        category = aCategory;
    }

    public boolean surgery(Pacient pacient, Diagnosis diagnosis) {
        return true;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
