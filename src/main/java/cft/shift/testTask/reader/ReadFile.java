package cft.shift.testTask.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
    public Scanner scanner;
    public ArrayList<String> filesName;
    public String fileName;

    public ReadFile(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.scanner = new Scanner(new File(fileName));
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void readString() {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
//            if (line.indexOf(' ') != -1) throw new RuntimeException("Строка содержит пробел");
            if (line.indexOf(' ') != -1) line = scanner.nextLine();
//            output.add(line);
            System.out.println(line);
        }
    }

    public void readInt() {
        while (scanner.hasNextInt()) {
//            outputInt.add(scanner.nextInt());
            System.out.println(scanner.nextInt());
        }
    }

    public String getFilePath() {
        Path path = Paths.get("").toAbsolutePath();
        return path.toString();
    }


}
