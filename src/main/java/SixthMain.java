import java.io.*;
import java.util.*;

public class SixthMain {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>();
        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        while (!exit) {
            showMenu();
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    people.add(getPerson());
                    break;
                case "2":
                    System.out.println(people);
                    break;
                case "3":
                    sortedDistinctList(people);
                    break;
                case "4":
                    writeToFile(people);
                    break;
                case "-1":
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong input. Try again");
                    break;
            }
        }
        scanner.close();
    }


    public static void showMenu() {
        System.out.println("Menu:");
        System.out.println("1.Add");
        System.out.println("2.Show");
        System.out.println("3.Show sorted unique");
        System.out.println("4.Write to file");
        System.out.println("-1.Exit");
    }

    public static Person getPerson() {
        try {
            FileWriter writer = new FileWriter("output.txt");
            BufferedWriter out = new BufferedWriter(writer);
            writer.write("asdadsdsa");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter last name: ");
        String secondName = scanner.next();
        return new Person(firstName, secondName);
    }

    public static void sortedDistinctList(List<Person> people) {
        System.out.print("List of secondnames");
        List<String> sortedLastNames = new ArrayList<>();
        people.stream().sorted(Comparator.comparing(Person::getLastName)).forEach(p -> sortedLastNames.add(p.getLastName()));
        sortedLastNames.stream().distinct().forEach(s -> System.out.print(s + " "));
        System.out.println();
    }

    public static void writeToFile(List<Person> people) {
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
}
