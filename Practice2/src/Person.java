import java.time.LocalDate;
import java.util.*;

public class Person implements Comparable<Person> {
    private String firstName;
    private String secondName;
    private LocalDate birthDate;
    private Set<Person> children = new HashSet<>();

    public Person(String firstName, String secondName, LocalDate birthDate) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
    }

    // Gettery potrzebne dla klasy Family
    public String getFirstName() { return firstName; }
    public String getSecondName() { return secondName; }
    public LocalDate getBirthDate() { return birthDate; }

    public boolean adopt(Person child) {
        return this.children.add(child);
    }

    public Person getYoungestChild() {
        if (children.isEmpty()) return null;

        Person youngest = null;
        for (Person child : children) {
            // Korzystamy z metody compareTo z Zadania 4
            if (youngest == null || child.compareTo(youngest) > 0) {
                youngest = child;
            }
        }
        return youngest;
    }

    public List<Person> getChildren() {
        List<Person> sortedChildren = new ArrayList<>(children);
        Collections.sort(sortedChildren); // Sortuje od najstarszego (najmniejsza data)
        return sortedChildren;
    }

    @Override
    public int compareTo(Person other) {
        // Naturalny porządek daty urodzenia
        return this.birthDate.compareTo(other.birthDate);
    }
}