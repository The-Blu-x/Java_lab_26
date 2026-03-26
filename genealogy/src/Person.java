import java.time.LocalDate;
import java.util.*;

public class Person implements Comparable<Person> {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthday;

    private final Set<Person> children = new HashSet<>();

    public Person(String firstName, String lastName, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public boolean adopt(Person child) {
        return this.children.add(child);
    }

    public Person getYoungestChild() {
        if (this.children.isEmpty()) {
            return null;
        }
        Person youngest = null;
        for (Person child : this.children) {
            if (youngest == null || child.compareTo(youngest) > 0) {
                youngest = child;
            }
        }

        return youngest;
    }

    public List<Person> getChildren() {
        List<Person> sortChildren = new ArrayList<>(this.children);
        Collections.sort(sortChildren);
        return sortChildren;
    }

    @Override
    public int compareTo(Person other) {
        return this.birthday.compareTo(other.birthday);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName=" + firstName  +
                ", lastName='" + lastName +
                ", birthday=" + birthday +
                ", children=" + children +
                "}";
    }
}
