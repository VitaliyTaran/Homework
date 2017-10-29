package Homework10;

public enum DetailType {
    HEAD {
        @Override
        public String toString() {
            return "Голова";
        }
    }, BODY {
        @Override
        public String toString() {
            return "Тело";
        }
    }, RIGHT_HAND {
        @Override
        public String toString() {
            return "Правая рука";
        }
    }, LEFT_HAND {
        @Override
        public String toString() {
            return "Левая рука";
        }
    }, RIGHT_LEG {
        @Override
        public String toString() {
            return "Правая нога";
        }
    }, LEFT_LEG {
        @Override
        public String toString() {
            return "Левая нога";
        }
    }, CPU, RAM, HDD
}