package cft.shift.testTask.sort;

import cft.shift.testTask.parser.Parser;
import cft.shift.testTask.reader.ReadFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Sort {
    public Parser parser;

    public Sort(Parser parser) throws IOException {
        this.parser = parser;
        sort();
    }

    public void sort() throws IOException {
        parser.readArgs();
        ArrayList<String> filesName = parser.getInputFilesName();
        String outputFilePath = parser.getFilePath() + "\\OutputFiles\\" + parser.getOutputFileName();
        FileWriter writer = new FileWriter(outputFilePath);

        for (int i = 0; i < filesName.size(); i++) {
            ReadFile read = new ReadFile(parser.getFilePath() + "\\InputFiles\\" + filesName.get(i));
            while (read.getScanner().hasNextLine()) {
                String line = read.getScanner().nextLine();
                writer.write(line + "\n");
            }
            writer.close();

//            System.out.println(parser.getInputFilesName().get(i));
        }
    }


}
