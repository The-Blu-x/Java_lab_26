import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Przykład: Rodzic Jan Kowalski, urodzony 1 stycznia 1980
        Person parent = new Person("Jan", "Kowalski", LocalDate.of(1980, 1, 1));
        // 1. Annę Kowalską (ur. 15 maja 2010)
        Person child1 = new Person("Anna", "Kowalska", LocalDate.of(2010, 5, 15));
        // 2. Piotra Kowalskiego (ur. 20 listopada 2015)
        Person child2 = new Person("Piotr", "Kowalski", LocalDate.of(2015, 11, 20));

        parent.adopt(child1);
        parent.adopt(child2);

        Person youngest = parent.getYoungestChild();
        if (youngest != null) {
            System.out.println("Najmłodsze dziecko to: " + youngest.getFirstName() + " " + youngest.getSecondName());
        }
        List<Person> list = new ArrayList<>();
        list = parent.getChildren();
        for (Person child : list) {
            System.out.println(child.getFirstName() + " " + child.getSecondName() + ", ur. " + child.getBirthDate());
        }

        Family family = new Family();
        family.add(parent); // Dodajemy Jana Kowalskiego do mapy pod kluczem "Jan Kowalski"

        Person check = family.get("Jan Kowalski");

        System.out.println(check.getFirstName() + " " + check.getSecondName());
    }
}