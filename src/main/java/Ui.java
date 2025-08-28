import java.util.Scanner;

public class Ui {
    // fields
    private Scanner scanner;

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
