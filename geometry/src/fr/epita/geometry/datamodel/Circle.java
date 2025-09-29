package fr.epita.geometry.datamodel;


public class Circle implements Shape{

    // private static final double PI = 3.14159;

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * this.radius * this.radius;
       // return Math.PI * Math.pow(this.radius, 2);
    }

    public double getPerimeter(){
        return 2 * Math.PI * this.radius;
    }

}
