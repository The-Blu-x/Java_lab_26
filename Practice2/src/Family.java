import java.util.HashMap;
import java.util.Map;

public class Family {
    public Map<String, Person> members = new HashMap<>();

    public void add(Person person) {
        String key = person.getFirstName() + " " + person.getSecondName();
        members.put(key, person); // Metoda .put zapisuje klucz i przypisaną do niego wartość
    }

    public Person get(String name) {
        return members.get(name);
    }
}
