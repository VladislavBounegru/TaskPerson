import seven.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThirdMain {

    public static void main(String[] args) {
        List<Person> people = getPeople();
        System.out.println(people);
    }

    public static List<Person> getPeople() {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        System.out.println("If you want to stop type \"-1\"");
        while(true){
            System.out.print("Enter first name: ");
            String firstName = scanner.next();
            if (firstName.equals("-1")){
                break;
            }
            System.out.print("Enter last name: ");
            String secondName = scanner.next();
            if (secondName.equals("-1")){
                break;
            }
            people.add(new Person(firstName, secondName));
        }
        scanner.close();
        return people;
    }

}