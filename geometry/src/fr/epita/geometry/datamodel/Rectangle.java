package fr.epita.geometry.datamodel;

import java.io.Serializable;

public class Rectangle implements Shape{

    private double width, length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        return width * length;
    }
    public double getPerimeter() {
        return 2 * width + 2 * length;
    }

}
