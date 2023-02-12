package cft.shift.testTask.parser;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Parser {
    private final String[] args;
    SortType sortType = SortType.UPPERSORT;
    DataType dataType;
    String outputFileName;
    ArrayList<String> inputFilesName = null;
    boolean isSortType = false;
    boolean isDataType = false;

    public Parser(String[] args) {
        this.args = args;
    }

    public DataType getDataType() {
        return dataType;
    }

    public SortType getSortType() {
        return sortType;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public ArrayList<String> getInputFilesName() {
        return inputFilesName;
    }

    public void readArgs() {
        int argsNumber = 0;
        inputFilesName = new ArrayList<>();

        if (args.length < 3) throw new IllegalArgumentException("Incorrect number of arguments!");
        if (args[0].charAt(0) != '-')
            throw new IllegalArgumentException("Wrong argument syntax, need a sign '-'");
        if (!checkSortType() && !checkDataType(argsNumber))
            throw new IllegalArgumentException("Wrong first argument, should be: '-s', '-i', '-a', '-d'");
        if (checkSortType()) {
            if (!checkDataType(argsNumber + 1))
                throw new IllegalArgumentException("Wrong second argument, should be: '-s' or '-i'");
            argsNumber += 2;
            argsNumber = checkOutputFileName(argsNumber);
        } else if (checkDataType(argsNumber)) {
            argsNumber++;
            argsNumber = checkOutputFileName(argsNumber);
        }
        inputFilesName.addAll(Arrays.asList(args).subList(argsNumber, args.length));
        if (inputFilesName.isEmpty()) throw new IllegalArgumentException("No input files!");
    }

    public boolean checkDataType(int argsNumber) {
        if (args[argsNumber].length() != 2) throw new IllegalArgumentException("Incorrect argument length!");
        if (args[argsNumber].charAt(1) == 's' || args[argsNumber].charAt(1) == 'i') {
            isDataType = true;
            if (args[argsNumber].charAt(1) == 'i') {
                dataType = DataType.INTEGER;
            } else if (args[argsNumber].charAt(1) == 's') {
                dataType = DataType.STRING;
            }
        }
        return isDataType;
    }

    public boolean checkSortType() {
        if (args[0].length() != 2) throw new IllegalArgumentException("Incorrect argument length!");
        if (args[0].charAt(1) == 'a' || args[0].charAt(1) == 'd') {
            isSortType = true;
            if (args[0].charAt(1) == 'a') {
                sortType = SortType.UPPERSORT;
            } else if (args[0].charAt(1) == 'd') {
                sortType = SortType.LOWERSORT;
            }
        }
        return isSortType;
    }

    public int checkOutputFileName(int argsNumber) {
        if (args[argsNumber].charAt(0) == '-')
            throw new IllegalArgumentException("A flag is entered instead of the output file name, or the order of the parameters is mixed up!");
        outputFileName = args[argsNumber];
        argsNumber++;
        return argsNumber;
    }

    public String getFilePath() {
        Path path = Paths.get("").toAbsolutePath();
        return path.toString();
    }

}
