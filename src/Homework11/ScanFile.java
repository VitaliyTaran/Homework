package Homework11;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ScanFile {
    private File file = new File("src" + File.separator + "Homework11" + File.separator + "schedule.txt");
    private File file1 = new File("src" + File.separator + "Homework11" + File.separator + "first.txt");
    private File file2 = new File("src" + File.separator + "Homework11" + File.separator + "second.txt");
    private List<String> list = new LinkedList<>();

    public List<String> getList() {
        return list;
    }

    public ScanFile() {
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(file)));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void printFile1() {
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(file1)));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printFile2() {
        try {
            Scanner scanner = new Scanner(new BufferedReader(new FileReader(file2)));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}