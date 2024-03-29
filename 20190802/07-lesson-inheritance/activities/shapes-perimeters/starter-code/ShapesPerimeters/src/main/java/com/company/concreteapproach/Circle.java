package com.company.concreteapproach;

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


//Concrete Class Implementation
//
//Using package com.company.concreteapproach, create a basic class called Shape.  Include properties for name, color, x coordinate, and y coordinate. Also provide an empty implementation for area() and perimeter() methods.
//Once you have the Shape class created, create the below classes. Each class will inherit from the Shape class. Each should have properties appropriate to them, and an implementation for area() and perimeter().
//
//Circle
//Square
//Triangle
//
//
//
//Abstract Class Implementation
//
//Using package com.company.abstractapproach, create an abstract class called Shape.  Include the same basic properties as before, but this time, declare the the area() and perimeter() methods as abstract.
//Again, create the Circle, Square, and Triangle classes, inheriting from the new abstract Shape class.
//
//interface Implementation
//
//Examine the starter code found in package com.company.interfaceapproach.  This is the same implementation that we previously created in our lesson on interfaces.
//
//Written Response
//
//In your own words, write a few paragraphs comparing and constrasting these approaches. Which implementation is "best?" Feel free to create an main method and test out each, if you feel that helps your understanding.