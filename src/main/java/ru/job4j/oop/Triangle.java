package ru.job4j.oop;

public class Triangle {

    private Point a;
    private Point b;
    private Point c;

    private double ab;
    private double ac;
    private double bc;

    public Triangle(Point first, Point second, Point third) throws IllegalArgumentException {
        a = first;
        b = second;
        c = third;
        if (!exist()) {
            throw new IllegalArgumentException("По указанным точкам нельзя построить треугольник, потому что все три точки лежат на одной прямой.");
        }
    }

    public boolean exist() {
        ab = a.distance(b);
        ac = a.distance(c);
        bc = b.distance(c);
        return ab + ac > bc && ac + bc > ab && bc + ab > ac;
    }

    public double halfPerimeter() {
        return (ab + ac + bc) / 2;
    }

    public double area() {
        double p = halfPerimeter();
        return Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
    }
}