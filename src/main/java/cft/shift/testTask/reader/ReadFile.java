package cft.shift.testTask.reader;

import cft.shift.testTask.parser.SortType;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public Scanner scanner;
    public String fileName;
    public String previous;
    public String current;
    SortType sortType;

    public ReadFile(String fileName, SortType sortType) throws FileNotFoundException, EOFException {
        this.fileName = fileName;
        this.scanner = new Scanner(new File(fileName));
        this.sortType = sortType;
        readNextLine();
    }

    public String getCurrent() {
        return this.current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String readNextLine() throws EOFException {
        if (!scanner.hasNextLine()) throw new EOFException("EOF");
        this.previous = this.current;
        this.current = scanner.nextLine();
        if (this.current.indexOf(' ') != -1 || (this.previous != null && sortingType(this.previous, this.current)))
            this.current = readNextLine();
        return this.current;
    }

    public boolean sortingType(String previous, String current) {
        return (sortType == SortType.UPPERSORT) ? previous.compareTo(current) > 0 : previous.compareTo(current) < 0;
    }

}
