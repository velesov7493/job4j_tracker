package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() { }

    public Error(boolean aActive, int aStatus, String aMessage) {
        active = aActive;
        status = aStatus;
        message = aMessage;
    }

    public void printInfo() {
        System.out.println("Активна: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error defaultError = new Error();
        Error paramsError1 = new Error(true, 3, "Ошибка с заполненными полями 1");
        Error paramsError2 = new Error(false, -11, "Ошибка с заполненными полями 2");
        defaultError.printInfo();
        paramsError1.printInfo();
        paramsError2.printInfo();
    }
}
