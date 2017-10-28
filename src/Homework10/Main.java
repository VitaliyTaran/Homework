package Homework10;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        List<Detail> firstList = new LinkedList<>();
        List<Detail> secondList = new LinkedList<>();

        Factory factory = new Factory();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CyclicBarrier barrier = new CyclicBarrier(3);
        factory.trowOutRandomPartsOfRobots(true);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new ThrowDitails(factory, barrier));
            while (!factory.getRandomDetails().isEmpty()) {
                if (Math.random() * 2 <= 1) {
                    if (!factory.getRandomDetails().isEmpty()) {
                        executorService.execute(new FirstThread(factory, firstList, barrier));
                    }
                } else {
                    if (!factory.getRandomDetails().isEmpty()) {
                        executorService.execute(new SecondThread(factory, secondList, barrier));
                    }
                }
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
            }
        }

        executorService.shutdown();
        factory.printListOfDetailsFromScientist(firstList);
        System.out.println("+++++++++");
        factory.printListOfDetailsFromScientist(secondList);
        System.out.println(whoIsWin(firstList, secondList));
        executorService.shutdownNow();
    }

    public static class ThrowDitails implements Runnable {
        private Factory factory;
        private CyclicBarrier barrier;

        public ThrowDitails(Factory factory, CyclicBarrier barrier) {
            this.factory = factory;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            synchronized (factory.getLock()) {
                factory.trowOutRandomPartsOfRobots(false);
            }
            try {
                Thread.sleep(50);
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
            }
        }
    }

    public static class FirstThread implements Runnable {
        private List<Detail> firstList;
        private Factory factory;
        private CyclicBarrier barrier;

        public FirstThread(Factory factory, List<Detail> firstList, CyclicBarrier barrier) {
            this.factory = factory;
            this.firstList = firstList;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            synchronized (factory.getLock()) {
                try {
                    if (!factory.getRandomDetails().isEmpty()) {
                        factory.takeFromDump(firstList);
                    }
                } catch (DetailException e) {
                    e.printStackTrace();
                }
            }
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
            }
        }
    }

    public static class SecondThread implements Runnable {
        private List<Detail> secondList;
        private Factory factory;
        private CyclicBarrier barrier;

        public SecondThread(Factory factory, List<Detail> secondList, CyclicBarrier barrier) {
            this.factory = factory;
            this.secondList = secondList;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            synchronized (factory.getLock()) {
                try {
                    if (!factory.getRandomDetails().isEmpty()) {
                        factory.takeFromDump(secondList);
                    }
                } catch (DetailException e) {
                    e.printStackTrace();
                }
            }
            try {
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
            }
        }
    }

    private static String whoIsWin(List<Detail> firstList, List<Detail> secondList) {
        int firstMin = 0;
        int secondMin = 0;

        for (Detail detail : firstList) {
            if (detail.getCounts() > firstMin) {
                firstMin = detail.getCounts();
            }
        }
        for (Detail detail : firstList) {
            if (detail.getCounts() < firstMin) {
                firstMin = detail.getCounts();
            }
        }
        for (Detail detail : secondList) {
            if (detail.getCounts() > secondMin) {
                secondMin = detail.getCounts();
            }
        }
        for (Detail detail : secondList) {
            if (detail.getCounts() < secondMin) {
                secondMin = detail.getCounts();
            }
        }
        return firstMin > secondMin ? "Победил первый ученый собравший " + firstMin + " роботов" : "Победил второй ученый собравший " + secondMin + " роботов";
    }
}