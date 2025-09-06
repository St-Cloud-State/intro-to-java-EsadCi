import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyMain2 {
    public static void main(String[] args) {
        PersonList p1 = new PersonList();
        try (Scanner in = new Scanner(new File("persons.txt"))) {
            p1.store(in);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        p1.display();

        System.out.println("find(\"101\") -> " + p1.find("101"));
        System.out.println("find(\"999\") -> " + p1.find("999"));

        //Added an option to search index info by ID
        System.out.println("Enter an ID to search: ");
        Scanner input = new Scanner(System.in);
        String sid = input.next();
        int index = p1.find(sid);
        if (index != -1) {
            System.out.println("Person found at index: " + index);
        } else {
            System.out.println("Person not found.");
        }

        input.close();
    }

}
