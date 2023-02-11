package cft.shift.testTask.sort;

import cft.shift.testTask.parser.Parser;
import cft.shift.testTask.reader.ReadFile;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Sort {
    public Parser parser;

    public int minIndex;

    public Sort(Parser parser) throws IOException {
        this.parser = parser;
        parser.readArgs();
        sort();
    }

    public void sort() throws IOException {

        ArrayList<String> inputFilesName = parser.getInputFilesName();
        String outputFilePath = parser.getFilePath() + "\\OutputFiles\\" + parser.getOutputFileName();
        FileWriter writer = new FileWriter(outputFilePath);

        ArrayList<ReadFile> ReaderList = createReaderList(inputFilesName);

        while (!ReaderList.isEmpty()) {
            this.minIndex = 0;
            for (int i = 1; i < ReaderList.size(); i++) {
                if (ReaderList.get(this.minIndex).getCurrent().compareTo(ReaderList.get(i).getCurrent()) > 0) {
//                    System.out.println("!~!!");
                    this.minIndex = i;
//                    System.out.println(ReaderList.size();
                }
//                System.out.println("index: " + minIndex + " i: " + i);
            }
//            System.out.println(this.minIndex);
//            System.out.println(ReaderList.get(this.minIndex).getCurrent());
            writer.write(ReaderList.get(this.minIndex).getCurrent() + "\n");
            try {
//                System.out.println("111 ");
                ReaderList.get(this.minIndex).readNextLine();
            } catch (EOFException | NoSuchElementException e) {
                ReaderList.remove(this.minIndex);
            }
        }
        writer.close();

//        for (int i = 0; i < inputFilesName.size(); i++) {
//            ReadFile reader = new ReadFile(parser.getFilePath() + "\\InputFiles\\" + inputFilesName.get(i));
//            while (reader.getScanner().hasNextLine()) {
//                String line = reader.getScanner().nextLine();
//                writer.write(line + "\n");
//            }
//            writer.close();
////            System.out.println(parser.getInputFilesName().get(i));
//        }
    }

    public ArrayList<ReadFile> createReaderList(ArrayList<String> inputFilesName) throws FileNotFoundException, EOFException {
        ArrayList<ReadFile> ReaderList = new ArrayList<>();
        for (int i = 0; i < inputFilesName.size(); i++) {
            ReadFile reader = new ReadFile(parser.getFilePath() + "\\InputFiles\\" + inputFilesName.get(i));
            ReaderList.add(reader);
        }
        return ReaderList;
    }


}
