package cft.shift.testTask.sort;

import cft.shift.testTask.parser.Parser;
import cft.shift.testTask.parser.SortType;
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
        ArrayList<ReadFile> ReaderList = createReaderList(inputFilesName, parser.getSortType());

        while (!ReaderList.isEmpty()) {
            this.minIndex = 0;
            for (int i = 1; i < ReaderList.size(); i++) {
                if (ReaderList.get(this.minIndex).sortingType(ReaderList.get(this.minIndex).getCurrent(), ReaderList.get(i).getCurrent()))
                    this.minIndex = i;
            }
            writer.write(ReaderList.get(this.minIndex).getCurrent());
            writer.append('\n');
            try {
                ReaderList.get(this.minIndex).readNextLine();
            } catch (EOFException | NoSuchElementException e) {
                ReaderList.remove(this.minIndex);
            }
        }
        writer.close();
    }

    public ArrayList<ReadFile> createReaderList(ArrayList<String> inputFilesName, SortType sortType) throws FileNotFoundException, EOFException {
        ArrayList<ReadFile> ReaderList = new ArrayList<>();
        for (int i = 0; i < inputFilesName.size(); i++) {
            ReadFile reader = new ReadFile(parser.getFilePath() + "\\InputFiles\\" + inputFilesName.get(i), sortType);
            ReaderList.add(reader);
        }
        return ReaderList;
    }


}
