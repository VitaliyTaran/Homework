package Homework6;

import java.util.Scanner;

import static Homework6.ShapeUtils.isRectangle;
import static Homework6.ShapeUtils.isTriangle;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координаты 1 токчи");
        Point point1 = new Point(scanner.nextInt(), scanner.nextInt());
        System.out.println("Введите координаты 2 токчи");
        Point point2 = new Point(scanner.nextInt(), scanner.nextInt());
        System.out.println("Введите координаты 3 токчи");
        Point point3 = new Point(scanner.nextInt(), scanner.nextInt());
        Triangle triangle = new Triangle(point1, point2, point3);
        Rectangle rectangle = new Rectangle(point1, point2);
        Circle circle = new Circle(point1, point2);
        Quadrate quadrate = new Quadrate(point1,point2);
        System.out.println(quadrate.toString());
        System.out.println(triangle.toString());
        System.out.println(rectangle.toString());
        System.out.println(circle.toString());
        System.out.println(isRectangle(rectangle)?"Фигура является прямоугольниом":"Не является прямоугольником");
        System.out.println(isTriangle(triangle)?"Фигура является треугольником":"Не является треугольниом");
        System.out.println(rectangle.isEqual(triangle)?"Площади двух фигур равны "+rectangle.square()
                +" и "+ triangle.square():"Площади двух фигур не равны "+rectangle.square()
                +" и "+ triangle.square());
        System.out.println(point1.toString());


    }
}