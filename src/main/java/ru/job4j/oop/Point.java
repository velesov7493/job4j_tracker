package ru.job4j.oop;

public class Point {

    private int x;
    private int y;
    private int z;

    public Point(int px, int py) {
        x = px;
        y = py;
    }

    public Point(int px, int py, int pz) {
        x = px;
        y = py;
        z = pz;
    }

    public double distance(Point that) {
        return Math.sqrt(Math.pow(that.x - x, 2) + Math.pow(that.y - y, 2));
    }

    public double distance3d(Point that) {
        return
            Math.sqrt(
                Math.pow(that.x - x, 2)
                + Math.pow(that.y - y, 2)
                + Math.pow(that.z - z, 2)
            );
    }

    public void info() {
        System.out.println("Point[" + x + ", " + y + ", " + z + "]");
    }

}
