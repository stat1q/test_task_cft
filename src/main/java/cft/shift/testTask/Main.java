package cft.shift.testTask;

import cft.shift.testTask.parser.Parser;

public class Main {
    public static void main(String[] args) {
    String str = "@abczA";
    char one = '@';
    int code;
    int n = str.length();

    for (int i = 0; i < n; i++) {
//       code = str.codePointAt(i);
    }

    String[] argsNew = new String[]{"-d", "-s", "-s", "jkashgf"};

    try {
        Parser parser = new Parser(argsNew);
//        parser.print();
        parser.readArgs();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    }
}
