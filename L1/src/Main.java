// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

import controller.Controller;
import repo.InMemoryRepo;
import repo.Repo;
import view.View;

public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!\n");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        Repo repo= new InMemoryRepo();
        Controller ctr= new Controller(repo);
        View view= new View(ctr);
        view.run();

    }
}