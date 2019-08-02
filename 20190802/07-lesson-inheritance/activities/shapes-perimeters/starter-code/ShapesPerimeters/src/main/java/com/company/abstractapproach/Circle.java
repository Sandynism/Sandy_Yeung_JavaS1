package com.company.abstractapproach;

public class Circle extends Shape{
    public Circle() {}

    double circumference, diameter, radius;

    public double getCircumference() {
        return circumference;
    }

    public void setCircumference(double circumference) {
        this.circumference = circumference;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double area() {
        double area = 3.14*Math.pow(radius,2);
        return area;
    }

    public double perimeter() {
        double perimeter = 2*3.14*radius;
        return perimeter;
    }
}
