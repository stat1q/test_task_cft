package cft.shift.testTask.sort;

import cft.shift.testTask.parser.SortType;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public interface Sort {
    void sort(String inputFilePath, ArrayList<String> inputFilesName, SortType sortType, FileWriter writer) throws IOException;
}
