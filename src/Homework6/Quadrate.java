package Homework6;

public class Quadrate extends Quadrilateral {

    public Quadrate(Point firstPointOfVerge, Point secondPointOfVerge) {
        setPoint1(firstPointOfVerge);
        setPoint2(secondPointOfVerge);
    }
    @Override
    public double square() {
        return (Math.pow(getPoint1().distance(getPoint2()), 2));
    }
    @Override
    public String toString() {
        return "Квадрат с сторонами " + getPoint1().distance(getPoint2()) + " на " + getPoint1().distance(getPoint2()) + " и площадью " + square();
    }
}