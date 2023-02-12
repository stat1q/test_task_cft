package cft.shift.testTask.reader;

import java.io.EOFException;
import java.io.FileWriter;
import java.io.IOException;

public interface ReadFile<T> {
    void readNextLine() throws EOFException;

    void writeLine(FileWriter writer) throws IOException;

    boolean sortingType(T previous, T current);

    T getCurrent();

}
