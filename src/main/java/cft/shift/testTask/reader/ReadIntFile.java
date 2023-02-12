package cft.shift.testTask.reader;

import cft.shift.testTask.parser.SortType;

import java.io.*;
import java.util.Scanner;

public class ReadIntFile implements ReadFile<Integer> {
    private final Scanner scanner;
    private final SortType sortType;
    private Integer current;


    public ReadIntFile(String fileName, SortType sortType) throws FileNotFoundException, EOFException {
        this.scanner = new Scanner(new File(fileName));
        this.sortType = sortType;
        readNextLine();
    }

    @Override
    public Integer getCurrent() {
        return this.current;
    }

    @Override
    public void readNextLine() throws EOFException {
        if (!scanner.hasNextInt()) throw new EOFException("EOF");
        Integer previous;
        previous = this.current;
        this.current = scanner.nextInt();
        if (previous != null && sortingType(previous, this.current))
            readNextLine();
    }

    @Override
    public boolean sortingType(Integer previous, Integer current) {
        return (sortType == SortType.UPPERSORT) ? previous > current : previous < current;
    }

    @Override
    public void writeLine(FileWriter writer) throws IOException {
        writer.write(String.valueOf(this.current));
        writer.append('\n');
    }

}
