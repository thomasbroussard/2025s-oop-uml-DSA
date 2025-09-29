package fr.epita.geometry.launcher;

import fr.epita.geometry.datamodel.*;

import java.util.ArrayList;
import java.util.List;

public class Launcher {

    public static void main(String[] args) {
        Circle circle = new Circle(9.0);
        circle.getPerimeter();
        circle.getArea();


        Triangle triangle = new Triangle(9,3, 4, 5);
        triangle.getArea();
        triangle.getPerimeter();


        Square square = new Square(9);
        square.getArea();
        square.getPerimeter();

        Rectangle rectangle = new Rectangle(3, 5);
        List<Shape> shapes = new ArrayList<>();


        List<Shape> listOfObjects = List.of(circle, triangle, square, rectangle);
        double totalArea = 0.0;
        double totalPerimeter = 0.0;
        for (Shape object : listOfObjects) {
            totalArea += object.getArea();
            totalPerimeter += object.getPerimeter();
        }

        System.out.println("total area: " + totalArea);
        System.out.println("total perimeter: " + totalPerimeter);


    }
}
