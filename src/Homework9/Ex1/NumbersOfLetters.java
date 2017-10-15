package Homework9.Ex1;


import java.io.*;
import java.util.*;

public class NumbersOfLetters {
    public static void main(String[] args) {
        File file = new File("src" + File.separator + "Homework9" + File.separator + "Ex1" + File.separator + "poem.txt");
        List<String> text = new ArrayList<>();
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                text.add(line.toLowerCase());
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        numberOfLetters(text);
    }
    private static void numberOfLetters(List<String> text) {
        for (char i = 'а'; i <= 'я'; i++) {
            int numberOfRepear = 0;
            for (int j = 0; j < text.size(); j++) {
                String line = text.get(j);
                for (int k = 0; k < line.length(); k++) {
                    if (i == line.charAt(k)) {
                        numberOfRepear += 1;
                    }
                }
            }
            System.out.println(i + " " + numberOfRepear);
        }
    }
}