package cft.shift.testTask.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {

//    public String outputFilePath = "E:\\JavaProjects\\Test\\test_task_cft\\OutputFiles\\";
//    public String outputFilePath = "out.txt";
    public FileWriter writer;

    public FileWriter getWriter() {
        return writer;
    }

    public void setWriter(FileWriter writer) {
        this.writer = writer;
    }

    public WriteFile(String outputFilePath) throws FileNotFoundException, IOException {
//        File outputFile = new File(outputFilePath);
//        this.outputFilePath = outputFilePath + fileName;
        this.writer = new FileWriter(new File(outputFilePath));
    }


//    public void write() {
//        while ()
//        writer.write();
//    }


}
