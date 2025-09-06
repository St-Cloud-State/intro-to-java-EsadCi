import java.util.LinkedList;
import java.util.Scanner;

public class PersonList {
    private LinkedList<Person> list = new LinkedList<>();
    
    public void store(Scanner input) {
        while (input.hasNext()) {
            String id = input.next();
            if (!input.hasNext()) break;
            String firstName = input.next();
            if(!input.hasNext()) break;
            String lastName = input.next();

            list.add(new Person(firstName, lastName, id));
        }
    }

    public void display() {
        for (Person p : list) {
            System.out.println(p);
        }
    }

    public int find(String sid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(sid)) {
                return i;
            }
        }
        return -1;
    }
}