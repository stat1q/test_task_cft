package cft.shift.testTask.reader;

import cft.shift.testTask.parser.SortType;

import java.io.*;
import java.util.Scanner;

public class ReadStringFile implements ReadFile<String> {
    public Scanner scanner;
    public String fileName;
    public String previous;
    public String current;
    SortType sortType;

    public ReadStringFile(String fileName, SortType sortType) throws FileNotFoundException, EOFException {
        this.fileName = fileName;
        this.scanner = new Scanner(new File(fileName));
        this.sortType = sortType;
        readNextLine();
    }

    @Override
    public String getCurrent() {
        return this.current;
    }

    @Override
    public void readNextLine() throws EOFException {
        if (!scanner.hasNextLine()) throw new EOFException("EOF");
        this.previous = this.current;
        this.current = scanner.nextLine();
        if (this.current.indexOf(' ') != -1 || (this.previous != null && sortingType(this.previous, this.current)))
            readNextLine();
    }

    @Override
    public boolean sortingType(String previous, String current) {
        return (sortType == SortType.UPPERSORT) ? previous.compareTo(current) > 0 : previous.compareTo(current) < 0;
    }

    @Override
    public void writeLine(FileWriter writer) throws IOException {
        writer.write(this.current);
        writer.append('\n');
    }

}
