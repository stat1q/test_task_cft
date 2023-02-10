package cft.shift.testTask.sort;

import cft.shift.testTask.parser.Parser;
import cft.shift.testTask.reader.ReadFile;
import cft.shift.testTask.reader.WriteFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Sort {
        public Parser parser;

    public Sort (Parser parser) throws IOException {
            this.parser = parser;

            sort();

    }


    public void sort() throws IOException {
        parser.readArgs();
        ArrayList<String> filesName = parser.getInputFilesName();

        for (int i = 0; i < filesName.size(); i++) {
            ReadFile read = new ReadFile(parser.getFilePath() + "\\InputFiles\\" + filesName.get(i));
            WriteFile write = new WriteFile(parser.getFilePath() + "\\OutputFiles\\" + filesName.get(i));
            while (read.getScanner().hasNextLine()) {
                String line = read.getScanner().nextLine();
                //TODO writer
            }
            
                read.readString();
//            for (int j = 0; j < ; j++) {
//
//            }


//            System.out.println(parser.getInputFilesName().get(i));
        }
    }

}
