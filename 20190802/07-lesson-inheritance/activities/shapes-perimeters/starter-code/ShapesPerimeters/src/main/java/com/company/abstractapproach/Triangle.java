package com.company.abstractapproach;

public abstract class Triangle extends Shape {
    public Triangle() {}

    int side1, side2, side3, height, base, angle;
    //    To find the area of a triangle, multiply the base by the height, and then divide by 2.
    public int area(int a, int b) {
        int area = (a * b) / 2;
        return area;
    }

    public int perimeter(int a, int b, int c) {
        int perimeter = a + b + c;
        return perimeter;
    }
}
