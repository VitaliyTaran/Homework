package Homework9.Ex2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args) {
        System.out.println("Введите число случайных элементов:");
        Scanner scanner = new Scanner(System.in);
        int numberOfRandomElements = scanner.nextInt();
        List<RandomNumbers> listOfRandomNumbers = new ArrayList<>();
        for (int i = 0; i <numberOfRandomElements; i++) {
            listOfRandomNumbers.add(new RandomNumbers());
        }
        Collections.sort(listOfRandomNumbers, new AscendingComparator());
        printToFileAndRead(listOfRandomNumbers);
    }
    private static void printToFileAndRead(List<RandomNumbers> listOfRandomNumbers) {
        File file = new File("file.txt");
        try {
            boolean wasCreated = file.createNewFile();
            if (wasCreated) {
                System.out.println("Файл был создан!");
            }
            System.out.println("Запись в файл.");
            Writer writer = new FileWriter(file);
            writer.write(listOfRandomNumbers.toString());
            writer.close();
        } catch (IOException e) {
        }
        try (Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(file)))) {
            System.out.println("Чтение с файла.");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
        }
    }
}
