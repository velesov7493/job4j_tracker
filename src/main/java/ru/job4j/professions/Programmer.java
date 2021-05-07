package ru.job4j.professions;

import java.util.Date;

public class Programmer extends Ingineer {

    private SkillLevel level;

    public Programmer(String aName, String aSurname, String aEducation, Date aBirthday, Company aCompany, Project aCurrentProject, SkillLevel aLevel) {
        super(aName, aSurname, aEducation, aBirthday, aCompany, aCurrentProject);
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
