package fr.epita.geometry.datamodel;

public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }
    public double getPerimeter() {
        return this.side * 4;
    }


}
