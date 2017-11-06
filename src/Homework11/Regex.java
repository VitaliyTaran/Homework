package Homework11;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private PrintFile printFile = new PrintFile();
    private Pattern pattern = Pattern.compile("^((\\d{2}):(\\d{2}))\\s?(\\W+)$");

    public void timeLag(List<String> list) {

        List<String> out = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            String line = list.get(i);
            Matcher matcher = pattern.matcher(line);
            if (!matcher.matches()){
                out.add("\n");
            }
                if (i > 0) {
                    String previousLine = list.get(i - 1);
                    Matcher matcherPreviousLine = pattern.matcher(previousLine);
                    if (matcher.matches() && matcherPreviousLine.matches()) {
                        out.add(matcherPreviousLine.group(1) + " - " + matcher.group(1) + " " + matcherPreviousLine.group(4));
                    }
                }
            }
        printFile.printInFile1(out);
    }

    public void statisticsEveryDay(List<String> list) {
        List<String> out = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        out.add("Информация об каждом дне:\n");
        for (int i = 0; i < list.size(); i++) {
            String line = list.get(i);
            Matcher matcher = pattern.matcher(line);
            if(!matcher.find()){
                form(out,map);
                map.clear();
                i++;
            }
            if (i > 0) {
                String previousLine = list.get(i - 1);
                Matcher matcherPreviousLine = pattern.matcher(previousLine);
                if (matcher.matches() && matcherPreviousLine.matches()) {
                    if (map.containsKey(matcherPreviousLine.group(4))) {
                        map.replace(String.valueOf(matcherPreviousLine.group(4)), map.get(matcherPreviousLine.group(4)),
                                map.get(matcherPreviousLine.group(4)) + (Integer.valueOf(matcher.group(2)) * 60
                                        - Integer.valueOf(matcherPreviousLine.group(2)) * 60
                                        + Integer.valueOf(matcher.group(3)) - Integer.valueOf(matcherPreviousLine.group(3))));
                    } else {
                        map.put(String.valueOf(matcherPreviousLine.group(4)), (Integer.valueOf(matcher.group(2)) * 60
                                - Integer.valueOf(matcherPreviousLine.group(2)) * 60
                                + Integer.valueOf(matcher.group(3)) - Integer.valueOf(matcherPreviousLine.group(3))));
                    }
                }

            }
        }
        form(out,map);
        printFile.printInFile2(out);
    }
    public void statisticsAll(List<String> list) {
        List<String> out = new LinkedList<>();
        out.add("Информация о курсе:\n");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            String line = list.get(i);
            Matcher matcher = pattern.matcher(line);
            if (i > 0) {
                String previousLine = list.get(i - 1);
                Matcher matcherPreviousLine = pattern.matcher(previousLine);
                if (matcher.matches() && matcherPreviousLine.matches()) {
                    if (map.containsKey(matcherPreviousLine.group(4))) {
                        map.replace(String.valueOf(matcherPreviousLine.group(4)), map.get(matcherPreviousLine.group(4)),
                                map.get(matcherPreviousLine.group(4)) + (Integer.valueOf(matcher.group(2)) * 60
                                        - Integer.valueOf(matcherPreviousLine.group(2)) * 60
                                        + Integer.valueOf(matcher.group(3)) - Integer.valueOf(matcherPreviousLine.group(3))));
                    } else {
                        map.put(String.valueOf(matcherPreviousLine.group(4)), (Integer.valueOf(matcher.group(2)) * 60
                                - Integer.valueOf(matcherPreviousLine.group(2)) * 60
                                + Integer.valueOf(matcher.group(3)) - Integer.valueOf(matcherPreviousLine.group(3))));
                    }
                }

            }
        }
        form(out,map);
        printFile.printInFile2(out);
    }
private void form (List<String> out,HashMap<String, Integer> map){
    int summ = 0;
    for (Integer value : map.values()) {
        summ += value;
    }
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
        String key = entry.getKey();
        Integer value = entry.getValue();
        out.add(key + ": " + value + " минут (" + (value * 100) / summ + "%)");
    }
    out.add("\n");
}
}