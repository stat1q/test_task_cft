package cft.shift.testTask;

import cft.shift.testTask.parser.Parser;
import cft.shift.testTask.sort.Sort;

public class Main {
    public static void main(String[] args) {

//        String[] argsNew = new String[]{"-d", "-s", "out", "inLow1.txt", "inLow2.txt", "inLow3.txt", "inLow4.txt"};
    String[] argsNew = new String[]{"-a", "-i", "outInt.txt", "in2.txt", "in3.txt", "in4.txt"};

        try {
            new Sort(new Parser(argsNew));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
