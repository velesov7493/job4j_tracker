package ru.job4j.professions;

import java.util.Date;

public class Builder extends Ingineer {

    private String currentTask;
    private int workersCount;

    public Builder(
            Company aCompany, Project aCurrentProject,
            String aCurrentTask, int aWorkersCount
    ) {
        super(aCompany, aCurrentProject);
        currentTask = aCurrentTask;
        workersCount = aWorkersCount;
    }

    public void createDocumentation(Project buildingProject) { }

    public boolean approveConstruction(Project buildingProject) {
        return true;
    }

    public String getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(String currentTask) {
        this.currentTask = currentTask;
    }

    public int getWorkersCount() {
        return workersCount;
    }

    public void setWorkersCount(int workersCount) {
        this.workersCount = workersCount;
    }
}
