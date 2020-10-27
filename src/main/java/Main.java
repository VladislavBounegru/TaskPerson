import seven.Person;

public class Main {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Incorrect number of arguments");
        } else {
            Person personFromArgs = getPersonFromArgs(args);
            System.out.println(personFromArgs);
        }
    }

    public static Person getPersonFromArgs(String[] args) {
        return new Person(args[0], args[1]);
    }

}
