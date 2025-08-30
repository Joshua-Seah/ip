package apleasebot.ui;

import java.util.Scanner;

/**
 * Class that encapsulates the logic required to intake user commands
 */
public class Ui {
    // fields
    private final Scanner scanner;

    // constructor
    public Ui() {
        this.scanner = new Scanner(System.in);
    }

    // methods
    public Scanner start() {
        return scanner;
    }

    public void close() {
        scanner.close();
    }

    public void showLoadingError() {
        System.out.println("Data load error");
    }
}
