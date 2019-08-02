package com.company.abstractapproach;

public abstract class Square extends Shape {
    public Square() {}

    int length;

    public double area(double a) {
        double area = a * a;
        return area;
    }

    public double perimeter(double a) {
        double perimeter = a + a + a + a;
        return perimeter;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
