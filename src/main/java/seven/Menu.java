package seven;


import com.sun.javafx.geom.Curve;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner;
    private List<MenuItem> items;
    private static Menu instance;

    private Menu(Scanner scanner) {
        items = new ArrayList<>();
        Menu.scanner = scanner;
        createMenuItems();
    }

    public static Menu getInstance(Scanner scanner) {
        if (instance == null) {
            instance = new Menu(scanner);
        }
        return instance;
    }

    private void createMenuItems() {
        items.add(new MenuItem("1. Add", Menu::menuAdd));
        items.add(new MenuItem("2. Show", Menu::menuShow));
        items.add(new MenuItem("3. Show sorted unique", Menu::menuShowSortedUniq));
        items.add(new MenuItem("4. Save to file", Menu::menuSaveToFile));
        items.add(new MenuItem("5. Read from file", Menu::menuReadFromFile));
        items.add(new MenuItem("6. Clear data in memory", Menu::menuClearData));
        items.add(new MenuItem("7. Exit", Menu::menuExit));
    }

    public void showMenu() {
        for (MenuItem menuItem : items) {
            System.out.println(menuItem.getName());
        }
    }

    private static void menuAdd(List<Person> people) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String secondName = scanner.nextLine();
        people.add(new Person(firstName, secondName));
    }

    private static void menuShow(List<Person> people) {
        System.out.println("List of people:");
        int idx = 1;
        for (Person person : people) {
            System.out.println(idx++ + ". " + person.getFirstName() + " " + person.getLastName());
        }
        System.out.println("---------------");
    }

    private static void menuShowSortedUniq(List<Person> people) {
        System.out.println("Unique sorted list:");
        int idx = 1;
        List<String> sortedLastNames = new ArrayList<>();
        people.stream().sorted(Comparator.comparing(Person::getLastName)).forEach(p -> sortedLastNames.add(p.getLastName()));
        sortedLastNames.stream().distinct().forEach(System.out::println);
        System.out.println("-------------------");
    }

    private static void menuSaveToFile(List<Person> people) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileOutputStream("output.txt"));
            for (Person person : people) {
                System.out.println(people);
                writer.println(person.getFirstName() + " " + person.getLastName());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void menuReadFromFile(List<Person> people) {
        try {
            int idx = 1;
            Files.lines(Paths.get("input.txt"), StandardCharsets.UTF_8).forEach(s -> {
                String person[] = s.split(" ");
                if (person.length > 1) {
                    people.add(new Person(person[0], person[1]));
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void menuClearData(List<Person> people) {
        people.clear();
    }

    private static void menuExit(List<Person> people) {
        System.exit(0);
    }

    public List<MenuItem> getItems() {
        return items;
    }
}
