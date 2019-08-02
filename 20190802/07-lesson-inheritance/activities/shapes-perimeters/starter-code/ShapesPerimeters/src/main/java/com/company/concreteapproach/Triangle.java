package com.company.concreteapproach;

public class Triangle {
    public Triangle() {
    }

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

    public int getSide1() {
        return side1;
    }

    public void setSide1(int side1) {
        this.side1 = side1;
    }

    public int getSide2() {
        return side2;
    }

    public void setSide2(int side2) {
        this.side2 = side2;
    }

    public int getSide3() {
        return side3;
    }

    public void setSide3(int side3) {
        this.side3 = side3;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

}

