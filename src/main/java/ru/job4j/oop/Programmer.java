package ru.job4j.oop;

public class Programmer extends Ingineer {

    public static enum SkillLevel {
        Intern,
        Junior,
        Middle,
        Senior
    }

    private SkillLevel level;

    public int estimate(Project project) {
        return 0;
    }

    public SkillLevel getLevel() {
        return level;
    }

    public void setLevel(SkillLevel level) {
        this.level = level;
    }
}
