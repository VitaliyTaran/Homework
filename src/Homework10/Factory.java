package Homework10;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    private static final Object LOCK = new Object();
    private static List<Detail> randomDetails = new ArrayList<>();

    public void trowOutRandomPartsOfRobots(boolean isFirstDay) {
        int numberOfDetailsInThePart;
        if (isFirstDay) {
            numberOfDetailsInThePart = 20;
        } else {
            numberOfDetailsInThePart = generateRandomNumber(4);
        }
        while (numberOfDetailsInThePart > 0) {
            int numberOfDetails = generateRandomNumber(numberOfDetailsInThePart);
            switch (generateRandomNumber(9)) {
                case 1:
                    numberOfDetailsInThePart -= numberOfDetails;
                    addToRandomDetails("HEAD", numberOfDetails);
                    break;
                case 2:
                    numberOfDetailsInThePart -= numberOfDetails;
                    addToRandomDetails("BODY", numberOfDetails);
                    break;
                case 3:
                    numberOfDetailsInThePart -= numberOfDetails;
                    addToRandomDetails("LEFT_HAND", numberOfDetails);
                    break;
                case 4:
                    numberOfDetailsInThePart -= numberOfDetails;
                    addToRandomDetails("RIGHT_HAND", numberOfDetails);
                    break;
                case 5:
                    numberOfDetailsInThePart -= numberOfDetails;
                    addToRandomDetails("LEFT_LEG", numberOfDetails);
                    break;
                case 6:
                    numberOfDetailsInThePart -= numberOfDetails;
                    addToRandomDetails("RIGHT_LEG", numberOfDetails);
                    break;
                case 7:
                    numberOfDetailsInThePart -= numberOfDetails;
                    addToRandomDetails("CPU", numberOfDetails);
                    break;
                case 8:
                    numberOfDetailsInThePart -= numberOfDetails;
                    addToRandomDetails("RAM", numberOfDetails);
                    break;
                case 9:
                    numberOfDetailsInThePart -= numberOfDetails;
                    addToRandomDetails("HDD", numberOfDetails);
                    break;
            }
        }
    }

    public void takeFromDump(List<Detail> detailsFromScientist) throws DetailException {
        if (randomDetails.isEmpty()) {
            throw new DetailException("В фабрике не осталось деталей, приходите в другой день.");
        }
        int detailType = 0 + (int) (Math.random() * (randomDetails.size() - 1));
        DetailType type = randomDetails.get(detailType).getType();
        if (isTypeConsisted(detailsFromScientist, type.name())) {
            detailsFromScientist.forEach(detail -> {
                if (detail.getType().equals(type)) {
                    detail.setCounts(detail.getCounts() + 1);
                }
            });
            if (randomDetails.get(detailType).getCounts() == 1) {
                randomDetails.remove(detailType);
            } else {
                randomDetails.get(detailType).setCounts(randomDetails.get(detailType).getCounts() - 1);
            }
        } else {
            detailsFromScientist.add(new Detail(randomDetails.get(detailType).getType(), 1));
            if (randomDetails.get(detailType).getCounts() == 1) {
                randomDetails.remove(detailType);
            } else {
                randomDetails.get(detailType).setCounts(randomDetails.get(detailType).getCounts() - 1);
            }
        }
    }

    public void printListOfDetails() {
        randomDetails.forEach(System.out::println);
    }

    public void printListOfDetailsFromScientist(List<Detail> detailsFromScientist) {
        detailsFromScientist.forEach(System.out::println);
    }

    private boolean addToRandomDetails(String type, int numberOfDetails) {
        if (isTypeConsisted(randomDetails, type)) {
            randomDetails.forEach(detail -> {
                if (detail.getType().name().equals(type)) {
                    detail.setCounts(detail.getCounts() + numberOfDetails);
                }
            });
        } else {
            randomDetails.add(new Detail(DetailType.valueOf(type), numberOfDetails));
        }
        return false;
    }

    private int generateRandomNumber(int limit) {
        return (int) Math.ceil(Math.random() * limit);
    }

    private boolean isTypeConsisted(List<Detail> details, String type) {
        for (Detail detail : details) {
            if (detail.getType().name().equals(type)) {
                return true;
            }
        }
        return false;
    }

    public List<Detail> getRandomDetails() {
        return randomDetails;
    }

    public Object getLock() {
        return LOCK;
    }
}