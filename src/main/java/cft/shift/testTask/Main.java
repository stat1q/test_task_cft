package cft.shift.testTask;

import cft.shift.testTask.parser.Parser;
import cft.shift.testTask.reader.ReadFile;
import cft.shift.testTask.reader.WriteFile;
import cft.shift.testTask.sort.Sort;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

    String[] argsNew = new String[]{"-d", "-s", "out.txt", "in2.txt", "in3.txt", "in4.txt"};

//    String fileName = "E:\\JavaProjects\\Test\\test_task_cft\\InputFiles\\in2.txt";

//    Path path = Paths.get("").toAbsolutePath();
//    String path = System.getProperty("user.dir");
//      String currentPath = path.toString();
//        System.out.println(currentPath);

    try {

        Sort sort = new Sort(new Parser(argsNew));
//        Parser parser = new Parser(argsNew);
//        parser.print();
//        parser.readArgs();

//        ReadFile read = new ReadFile(fileName);
//        read.readString();


//        WriteFile write = new WriteFile(parser.getOutputFileName());


    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    }
}
