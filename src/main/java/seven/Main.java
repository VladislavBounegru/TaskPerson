package seven;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Person> people = new ArrayList<>();
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        Menu menu = Menu.getInstance(scanner);
        while (true) {
            menu.showMenu();
            run(menu);
        }
    }

    public static void run(Menu menu) {
        String input = scanner.nextLine();
        try {
            int index = Integer.parseInt(input);
            if (index < 1 || index > 7) {
                throw new Exception();
            }
            menu.getItems().get(index - 1).getExec().exec(people);
        } catch (Exception e) {
            System.out.println("Wrong input");
        }
    }

//
}