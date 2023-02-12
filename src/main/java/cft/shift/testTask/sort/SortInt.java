package cft.shift.testTask.sort;

import cft.shift.testTask.parser.SortType;
import cft.shift.testTask.reader.ReadIntFile;

import java.io.EOFException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class SortInt implements Sort {

    public void sort(String inputFilesPath, ArrayList<String> inputFilesName, SortType sortType, FileWriter writer) throws IOException {
        ArrayList<ReadIntFile> IntReaderList = new ArrayList<>();
        for (String fileName : inputFilesName) {
            ReadIntFile reader = new ReadIntFile(inputFilesPath + fileName, sortType);
            IntReaderList.add(reader);
        }
        while (!IntReaderList.isEmpty()) {
            int extremeIndex = 0;
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
