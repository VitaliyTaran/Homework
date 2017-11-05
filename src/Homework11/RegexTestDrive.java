package Homework11;

public class RegexTestDrive {
    public static void main(String[] args) {
        ScanFile scanFile = new ScanFile();
        Regex regex = new Regex();
        regex.timeLag(scanFile.getList());
        regex.statisticsAll(scanFile.getList());
        regex.statisticsEveryDay(scanFile.getList());
        scanFile.printFile1();
        System.out.println("\n================\n");
        scanFile.printFile2();
    }
}