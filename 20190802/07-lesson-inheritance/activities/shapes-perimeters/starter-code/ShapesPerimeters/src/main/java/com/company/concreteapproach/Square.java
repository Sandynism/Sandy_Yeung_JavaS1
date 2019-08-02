package com.company.concreteapproach;

public class Square {
    public Square() {}

    int length;

    public int area(int a) {
        int area = a * a;
        return area;
    }

    public int perimeter(int a) {
        int perimeter = a + a + a + a;
        return perimeter;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }


}
