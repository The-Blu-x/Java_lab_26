import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Person {
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

    @Override
    public String toString() {
        return firstName + " " + lastName + ", ur. " + birthday;
    }
}
