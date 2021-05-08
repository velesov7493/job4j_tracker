package ru.job4j.professions;

import java.util.Date;

public class Programmer extends Ingineer {

    private SkillLevel level;

    public Programmer(Company aCompany, Project aCurrentProject, SkillLevel aLevel) {
        super(aCompany, aCurrentProject);
        level = aLevel;
    }

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
