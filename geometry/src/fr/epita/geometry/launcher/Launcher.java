package fr.epita.geometry.launcher;

import fr.epita.geometry.datamodel.Circle;
import fr.epita.geometry.datamodel.Shape;
import fr.epita.geometry.datamodel.Square;
import fr.epita.geometry.datamodel.Triangle;

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
        List<Shape> listOfObjects = List.of(circle, triangle, square);
        double totalArea = 0.0;
        for (Shape object : listOfObjects) {
            totalArea += object.getArea();
        }

        System.out.println("total area: " + totalArea);



    }
}
