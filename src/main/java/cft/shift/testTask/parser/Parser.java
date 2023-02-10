package cft.shift.testTask.parser;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

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

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public SortType getSortType() {
        return sortType;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }

    public String getOutputFileName() {
        return outputFileName;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }
    public ArrayList<String> getInputFilesName() {
        return inputFilesName;
    }

    public void setInputFilesName(ArrayList<String> inputFilesName) {
        this.inputFilesName = inputFilesName;
    }

    public void readArgs() {
        int argsNumber = 0;
        inputFilesName = new ArrayList<>();

        if (args.length < 3) throw new IllegalArgumentException("Wrong numbers of argument");
        if (args[0].charAt(0) != '-') throw new IllegalArgumentException("Неверный аргумент, нужен знак '-'");
        if (!checkSortType() && !checkDataType(argsNumber))
            throw new IllegalArgumentException("Неверный аргумент, должен быть 's, i, a, d'");
        if (checkSortType()) {
            if (!checkDataType(argsNumber + 1))
                throw new IllegalArgumentException("Неверный аргумент, должен быть 's, i'");
            argsNumber += 2;
            argsNumber = checkOutputFileName(argsNumber);
//            System.out.println(outputFileName);
        } else if (checkDataType(argsNumber)) {
            argsNumber++;
            argsNumber = checkOutputFileName(argsNumber);
//            System.out.println(outputFileName);
        }
        for (int i = argsNumber; i < args.length; i++) {
//            System.out.println(argsNumber);
            inputFilesName.add(args[i]);
        }
//        System.out.println(inputFilesName);
        if (inputFilesName.isEmpty()) throw new IllegalArgumentException("Нет входных файлов");
    }

    public boolean checkDataType(int argsNumber) {
        if (args[argsNumber].length() != 2) throw new IllegalArgumentException("Неверная длина аргумента");
        if (args[argsNumber].charAt(1) == 's' || args[argsNumber].charAt(1) == 'i') {
            isDataType = true;
            if (args[argsNumber].charAt(1) == 'i') {
                dataType = DataType.INTEGER;
//                System.out.println("файл integer");
            } else if (args[argsNumber].charAt(1) == 's') {
                dataType = DataType.STRING;
//                System.out.println("файл string");
            }
        }
        return isDataType;
    }

    public boolean checkSortType() {
        if (args[0].length() != 2) throw new IllegalArgumentException("Неверная длина аргумента");
        if (args[0].charAt(1) == 'a' || args[0].charAt(1) == 'd') {
            isSortType = true;
            if (args[0].charAt(1) == 'a') {
                sortType = SortType.UPPERSORT;
//                System.out.println("Сортировка по возрастанию");
            } else if (args[0].charAt(1) == 'd') {
                sortType = SortType.LOWERSORT;
//                System.out.println("Сортировка по убыванию");
            }
        }
        return isSortType;
    }

    public int checkOutputFileName(int argsNumber) {
        if (args[argsNumber].charAt(0) == '-')
            throw new IllegalArgumentException("Введите корректное название выходного файла");
        outputFileName = args[argsNumber];
        argsNumber++;
        return argsNumber;
    }

    public void print() {
        if (args.length == 0) throw new IllegalArgumentException("ERROR");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }

    public String getFilePath() {
        Path path = Paths.get("").toAbsolutePath();
        return path.toString();
    }

}
