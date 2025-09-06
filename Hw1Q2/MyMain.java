import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Scanner;

public class MyMain {
    public static void store(Scanner input, LinkedList<Person> list) {
        while (input.hasNext()) {
            String id =input.next();
            if (!input.hasNext()) break;
            String firstName = input.next();
            if (!input.hasNext()) break;
            String lastName = input.next();

            list.add(new Person(firstName, lastName, id));
        }
    }

    public static void display(PrintStream out, LinkedList<Person> list) {
        for (Person p : list) {
            out.println(p);
        }
    }
    
    public static int find(String sid, LinkedList<Person> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinkedList<Person> people = new LinkedList<>();
        try (Scanner fileIn = new Scanner(new File("persons.txt"))) {
            store(fileIn, people);
        } catch (FileNotFoundException e) {
                System.out.println("Could not open file persons.txt");
        }

        //Testing out code
        display(System.out, people);


        System.out.println("Find(\"101\") -> index " + find ("101", people));
        System.out.println("Find(\"999\") -> index " + find ("999", people));
        System.out.println("Find(\"109\") -> index " + find ("109", people));
    }
}

