import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Person implements Comparable<Person> {
    private String firstName;
    private String secondName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Set<Person> children = new HashSet<>();

    public Person(String firstName, String secondName, LocalDate birthDate, LocalDate deathDate) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    // Gettery potrzebne dla klasy Family
    public String getFirstName() { return firstName; }
    public String getSecondName() { return secondName; }
    public LocalDate getBirthDate() { return birthDate; }
    public LocalDate getDeathDate() { return deathDate; }

    public static Person fromCsvLine(String line) {
        String[] columns = line.split(",");
        String[] fullname = columns[0].split(" ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthDate = LocalDate.parse(columns[1], formatter);
        LocalDate deathDate = null;
        if (!columns[2].isEmpty()){
            deathDate = LocalDate.parse(columns[2], formatter);
        }
        return new Person(fullname[0], fullname[1], birthDate, deathDate);
    }

    public List<Person> fromCsv(String path) throws java.io.IOException {
        List<Person> people = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine(); // Pomijamy pierwszą linię (nagłówek)

            String line;
            while ((line = br.readLine()) != null) {
                // Tutaj użyjemy Twojej metody fromCsvLine!
                people.add(fromCsvLine(line));
            }
        }
        return people;
    }

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