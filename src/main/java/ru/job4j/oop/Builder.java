package ru.job4j.oop;

public class Builder extends Ingineer {

    private String currentTask;
    private int workersCount;

    public void createDocumentation(Project buildingProject) {}

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
