package fr.epita.geometry.datamodel;

public class Triangle implements Shape{
    private double base;
    private double sideB;
    private double sideC;
    private double height;

    public Triangle(double base, double sideB, double sideC, double height) {
        this.base = base;
        this.sideB = sideB;
        this.sideC = sideC;
        this.height = height;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return this.base * this.height / 2;
    }

    public double getPerimeter() {
       return this.base + this.sideB + this.sideC;
    }
}
