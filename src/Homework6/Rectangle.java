package Homework6;

public class Rectangle extends Quadrilateral {

    public Rectangle(Point uppLeftPoint, Point bottRightPoint) {
        setPoint1(uppLeftPoint);
        setPoint2(bottRightPoint);
    }
    public void setUppLeftPoint(Point uppLeftPoint) {
        setPoint1(uppLeftPoint);
    }
    public void setBottRightPoint(Point bottRightPoint) {
        setPoint2(bottRightPoint);
    }
    public double lengthOfDiagonal() {
        return getPoint1().distance(getPoint2());
    }
    @Override
    public double square() {
        Point point3 = new Point(getPoint2().getX(), getPoint1().getY());
        return getPoint1().distance(point3) * point3.distance(getPoint2());
    }
    @Override
    public String toString() {
        return "Площадь трямоугольника образованного точками 1 (" + getPoint1().getX() + "." + getPoint1().getY()
                + ") и 2 (" + getPoint2().getX() + "." + getPoint2().getY() + ") равна " + square();
    }
}