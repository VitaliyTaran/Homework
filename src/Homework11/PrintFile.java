package Homework11;

import java.io.*;
import java.util.List;


public class PrintFile {
    private File file1 = new File("src" + File.separator + "Homework11" + File.separator + "first.txt");
    private File file2 = new File("src" + File.separator + "Homework11" + File.separator + "second.txt");
    private PrintWriter printWriterFile2;
    private PrintWriter printWriterFile1;

    public PrintFile() {
        try {
            printWriterFile2 = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file2)));
            printWriterFile1 = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file1)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printInFile1(List<String> list) {
        for (String elements : list) {
            printWriterFile1.write(elements + "\n");
            printWriterFile1.flush();
        }
    }
    public void printInFile2(List<String> list) {
        for (String elements : list) {
            printWriterFile2.write(elements + "\n");
            printWriterFile2.flush();
        }
    }
}