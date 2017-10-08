package Homework6;

public class Circle extends Figure {

    public Circle(Point centre, Point pointOnTheCircle) {
        setPoint1(centre);
        setPoint2(pointOnTheCircle);
    }
    @Override
    public double square() {
        return (Math.PI * Math.pow(getPoint1().distance(getPoint2()), 2));
    }
    @Override
    public String toString() {
        return "Площадь круга с центром в точке 1 c координатами(" + getPoint1().getX() + "." + getPoint1().getY() + ") и радиусом "
                + getPoint1().distance(getPoint2()) + " равна " + square();
    }
}


