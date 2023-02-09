package cft.shift.testTask.parser;

import java.util.ArrayList;

public class Parser {
    private final String[] args;
    SortType sortType = SortType.UPPERSORT;
    DataType dataType;
    String outputFileName;
    ArrayList<String> inputFilesName;

    boolean FileTypeDefined = false;

    public Parser(String[] args) {
        this.args = args;
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
            outputFileName = args[argsNumber + 2];
            argsNumber += 3;
        } else if (checkDataType(argsNumber)) {
            outputFileName = args[argsNumber + 1];
            argsNumber += 2;
        }
        for (int i = argsNumber; i < args.length; i++) {
            inputFilesName.add(args[argsNumber]);
            System.out.println(args[i]);
        }
        if (inputFilesName.isEmpty()) throw new IllegalArgumentException("Нет входных файлов");
    }

    public boolean checkDataType(int argsNumber) {
        if (args[argsNumber].length() != 2) throw new IllegalArgumentException("Неверная длина аргмента");
        boolean isDataType = false;
        if (args[argsNumber].charAt(1) == 's' || args[argsNumber].charAt(1) == 'i') {
            isDataType = true;
            if (args[argsNumber].charAt(1) == 'i') {
                dataType = DataType.INTEGER;
                System.out.println("файл integer");
            } else if (args[argsNumber].charAt(1) == 's') {
                dataType = DataType.STRING;
                System.out.println("файл string");
            }
        }
        return isDataType;
    }

    public boolean checkSortType() {
        if (args[0].length() != 2) throw new IllegalArgumentException("Неверная длина аргмента");
        boolean isSortType = false;
        if (args[0].charAt(1) == 'a' || args[0].charAt(1) == 'd') {
            isSortType = true;
//            FileTypeDefined = true;
            if (args[0].charAt(1) == 'a') {
                sortType = SortType.UPPERSORT;
                System.out.println("Сортировка по возрастанию");
            } else if (args[0].charAt(1) == 'd') {
                sortType = SortType.LOWERSORT;
                System.out.println("Сортировка по убыванию");
            }
        }
        return isSortType;
    }

    public void print() {
        if (args.length == 0) throw new IllegalArgumentException("ERROR");
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}
