package Homework6;

/**
 * Created by Vitaliy on 05.10.2017.
 */
public class Triangle extends Figure {

    private double semiperimeter;

    public Triangle(Point firstPointOfTriangle, Point secondPointOfTriangle, Point thirdPointOfTriangle) {
        setPoint1(firstPointOfTriangle);
        setPoint2(secondPointOfTriangle);
        setPoint3(thirdPointOfTriangle);
    }
    @Override
    public double square() {
        semiperimeter = ((getPoint1().distance(getPoint2())
                + getPoint2().distance(getPoint3())
                + getPoint1().distance(getPoint3())) / 2);
        return (Math.sqrt(semiperimeter
                * (semiperimeter - getPoint1().distance(getPoint2()))
                * (semiperimeter - getPoint2().distance(getPoint3()))
                * (semiperimeter - getPoint1().distance(getPoint3()))));
    }

    public String isEquilateral() {
        if (getPoint1().distance(getPoint2()) == getPoint3().distance(getPoint2())
                && getPoint3().distance(getPoint2()) == getPoint1().distance(getPoint3())
                && getPoint1().distance(getPoint2()) == getPoint1().distance(getPoint3())) {
            return "равностороннего";
        } else {
            if (getPoint1().distance(getPoint2()) == getPoint3().distance(getPoint2())
                    || getPoint3().distance(getPoint2()) == getPoint1().distance(getPoint3())
                    || getPoint1().distance(getPoint2()) == getPoint1().distance(getPoint3())) {
                return "равнобедренного";
            }else return "";
        }
    }
    @Override
    public String toString() {
        return "Площадь " + isEquilateral() + " треугольника образованного точками 1 (" + getPoint1().getX() + "." + getPoint1().getY() + ") 2 ("
                + getPoint2().getX() + "." + getPoint2().getY() + ") 3 (" + getPoint3().getX() + "." + getPoint3().getY() + ") равна " + square();
    }
}