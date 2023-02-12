package cft.shift.testTask.sort;

import cft.shift.testTask.parser.DataType;
import cft.shift.testTask.parser.Parser;
import cft.shift.testTask.reader.ReadIntFile;
import cft.shift.testTask.reader.ReadStringFile;

import java.io.EOFException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Sort {
    public Parser parser;
    public int extremeIndex;
    public ArrayList<String> inputFilesName;
    public String outputFilePath;
    public FileWriter writer;
    public String inputFilesPath;

    public Sort(Parser parser) throws IOException {
        this.parser = parser;
        parser.readArgs();
        this.inputFilesPath = parser.getFilePath() + "\\InputFiles\\";
        this.inputFilesName = parser.getInputFilesName();
        this.outputFilePath = parser.getFilePath() + "\\OutputFiles\\" + parser.getOutputFileName();
        this.writer = new FileWriter(this.outputFilePath);
        selectSortType();
    }

    public void selectSortType() throws IOException {
        if (parser.getDataType() == DataType.STRING) {
            sortString();
        } else if (parser.getDataType() == DataType.INTEGER) {
            sortInt();
        }
    }

    public void sortString() throws IOException {
        ArrayList<ReadStringFile> StringReaderList = new ArrayList<>();
        for (String fileName : inputFilesName) {
            ReadStringFile reader = new ReadStringFile(inputFilesPath + fileName, parser.getSortType());
            StringReaderList.add(reader);
        }
        while (!StringReaderList.isEmpty()) {
            extremeIndex = 0;
            for (int i = 1; i < StringReaderList.size(); i++) {
                if (StringReaderList.get(extremeIndex).sortingType(StringReaderList.get(extremeIndex).getCurrent(), StringReaderList.get(i).getCurrent()))
                    extremeIndex = i;
            }
            StringReaderList.get(extremeIndex).writeLine(writer);
            try {
                StringReaderList.get(extremeIndex).readNextLine();
            } catch (EOFException | NoSuchElementException e) {
                StringReaderList.remove(extremeIndex);
            }
        }
        writer.close();
    }

    public void sortInt() throws IOException {
        ArrayList<ReadIntFile> IntReaderList = new ArrayList<>();
        for (String fileName : inputFilesName) {
            ReadIntFile reader = new ReadIntFile(inputFilesPath + fileName, parser.getSortType());
            IntReaderList.add(reader);
        }
        while (!IntReaderList.isEmpty()) {
            extremeIndex = 0;
            for (int i = 1; i < IntReaderList.size(); i++) {
                if (IntReaderList.get(extremeIndex).sortingType(IntReaderList.get(extremeIndex).getCurrent(), IntReaderList.get(i).getCurrent()))
                    extremeIndex = i;
            }
            IntReaderList.get(extremeIndex).writeLine(writer);
            try {
                IntReaderList.get(extremeIndex).readNextLine();
            } catch (EOFException | NoSuchElementException e) {
                IntReaderList.remove(extremeIndex);
            }
        }
        writer.close();
    }

}
