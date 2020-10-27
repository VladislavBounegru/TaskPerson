import seven.Person;

import java.util.Scanner;

public class SecondMain {

    public static void main(String[] args) {
        Person person = getPerson();
        System.out.println(person);

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