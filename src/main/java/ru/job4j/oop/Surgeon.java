package ru.job4j.oop;

public class Surgeon extends Doctor {

    private String category;

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
