package fr.epita.geometry.launcher;

import fr.epita.geometry.datamodel.Circle;
import fr.epita.geometry.datamodel.Triangle;

public class Launcher {

    public static void main(String[] args) {
        Circle circle = new Circle(9.0);

        circle.getPerimeter();
        circle.getArea();


        Triangle triangle = new Triangle(9,3, 4, 5);
        triangle.getArea();
        triangle.getPerimeter();


    }
}
