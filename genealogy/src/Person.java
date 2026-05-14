import java.time.LocalDate;
import java.util.*;

public class Person implements Comparable<Person> {
    private final String firstName;
    private final String lastName;
    private final LocalDate birthday;
    private final LocalDate death

    private final Set<Person> children = new HashSet<>();

    public Person(String firstName, String lastName, LocalDate birthday, LocalDate death) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.death = death;
    }
    public Person(String firstName, String lastName, LocalDate birthday) {
        this(firstName ,lastName, birthday, null);
    }

    public static Person formCsvLine(String line){
        String[] columns = line.split(",");
        String fullName = columns[0];
        String[] name = fullName.split(" ");
        String fname = name[0];
        String lname = name[1];
        String birth = columns[1];
        String death = columns[2];
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
