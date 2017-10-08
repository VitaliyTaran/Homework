package Homework7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EveryFourElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        strings.add(scanner.next());
        strings.add(scanner.next());
        strings.add(scanner.next());
        strings.add(scanner.next());
        strings.add(scanner.next());
        strings.add(scanner.next());
        strings.add(scanner.next());
        strings.add(scanner.next());
        markLenght4(strings);
    }

    private static void markLenght4(List<String> strings) {
        List<String> strings2 = new ArrayList<>();
        for (String element : strings) {
            if (element.length() == 4) {
                strings2.add("****");
                strings2.add(element);
            } else {
                strings2.add(element);
            }
        }
        for (String elements : strings2) {
            System.out.println(elements);
        }
    }
}
