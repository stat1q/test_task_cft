package cft.shift.testTask;

import cft.shift.testTask.parser.Parser;
import cft.shift.testTask.sort.Sort;

public class Main {
    public static void main(String[] args) {
        try {
            new Sort(new Parser(args));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
