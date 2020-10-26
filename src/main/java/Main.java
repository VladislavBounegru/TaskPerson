import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

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
        System.out.println("3.Exit");
    }

    public static Person getPerson() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scanner.next();
        System.out.print("Enter last name: ");
        String secondName = scanner.next();
        return new Person(firstName, secondName);
    }

}
