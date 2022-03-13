package ru.job4j.professions;

import java.util.Date;

public class Ingineer extends Profession {

    private Company company;
    private Project currentProject;

    public Ingineer(Company aCompany, Project aCurrentProject) {
        super();
        company = aCompany;
        currentProject = aCurrentProject;
    }

    public void work() {
    }

    public void workOvertime(Project overtimeProject) {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Project getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;
    }
}
