package ru.job4j.oop;

public class Point {

    private int x;
    private int y;

    public Point(int px, int py) {
        x = px;
        y = py;
    }

    public double distance(Point that) {
        return Math.sqrt(Math.pow(that.x - x, 2) + Math.pow(that.y - y, 2));
    }
}
