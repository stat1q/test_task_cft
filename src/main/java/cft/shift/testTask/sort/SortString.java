package cft.shift.testTask.sort;

import cft.shift.testTask.parser.SortType;
import cft.shift.testTask.reader.ReadStringFile;

import java.io.EOFException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class SortString implements Sort{

    @Override
    public void sort(String inputFilesPath, ArrayList<String> inputFilesName, SortType sortType, FileWriter writer) throws IOException {
        ArrayList<ReadStringFile> StringReaderList = new ArrayList<>();
        for (String fileName : inputFilesName) {
            ReadStringFile reader = new ReadStringFile(inputFilesPath + fileName, sortType);
            StringReaderList.add(reader);
        }
        while (!StringReaderList.isEmpty()) {
            int extremeIndex = 0;
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

}
