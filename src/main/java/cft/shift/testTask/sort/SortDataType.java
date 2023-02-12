package cft.shift.testTask.sort;

import cft.shift.testTask.parser.DataType;
import cft.shift.testTask.parser.Parser;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SortDataType {
    private final Parser parser;
    private final ArrayList<String> inputFilesName;
    private final FileWriter writer;
    private final String inputFilesPath;
    private String inputDirectory;
    private String outputDirectory;

    public SortDataType(Parser parser) throws IOException {
        this.parser = parser;
        parser.readArgs();
        OSCheck();
        this.inputFilesPath = parser.getFilePath() + inputDirectory;
        this.inputFilesName = parser.getInputFilesName();
        this.writer = new FileWriter(parser.getFilePath() + outputDirectory + parser.getOutputFileName());
        selectSortType();
    }

    private void OSCheck() {
        if (System.getProperty("os.name").startsWith("Windows")) {
            inputDirectory = "\\InputFiles\\";
            outputDirectory = "\\OutputFiles\\";
        } else {
            inputDirectory = "/InputFiles/";
            outputDirectory = "/OutputFiles/";
        }
    }

    private void selectSortType() throws IOException {
        if (parser.getDataType() == DataType.STRING) {
            SortString sortString = new SortString();
            sortString.sort(inputFilesPath, inputFilesName, parser.getSortType(), writer);
        } else if (parser.getDataType() == DataType.INTEGER) {
            SortInt sortInt = new SortInt();
            sortInt.sort(inputFilesPath, inputFilesName, parser.getSortType(), writer);
        }
    }

}
