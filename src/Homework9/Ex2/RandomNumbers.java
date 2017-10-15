package Homework9.Ex2;

public class RandomNumbers {
    private int randomNumber;
    public RandomNumbers() {
        this.randomNumber = generateOfRandomNumbers();
    }
    public int getRandomNumber() {
        return randomNumber;
    }
    public static int generateOfRandomNumbers() {
        return (int) (Math.random() * 100);
    }
    @Override
    public String toString() {
        return "" + randomNumber;
    }
}
