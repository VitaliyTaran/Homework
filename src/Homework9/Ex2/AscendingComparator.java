package Homework9.Ex2;

import java.util.Comparator;

public class AscendingComparator implements Comparator<RandomNumbers> {
    @Override
    public int compare(RandomNumbers firstNumber, RandomNumbers secondNumber) {
        return new Integer(firstNumber.getRandomNumber()).compareTo(secondNumber.getRandomNumber());
    }
}
