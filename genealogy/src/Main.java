import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Person> people = new ArrayList<>();
        people.add(new Person("Mike", "Tyson" , LocalDate.of(2004,2,4)));
        people.add(new Person("Sebastian", "Rocky" , LocalDate.of(2003,12,24)));
        people.add(new Person("Daniel", "Albert" , LocalDate.of(2006,4,7)));

        Person parent = people.get(0);   // Mike
        Person child = people.get(2);

        boolean didItWorked = parent.adopt(child);
        System.out.println("Czy adopcja się powiodła? " + didItWorked);
        System.out.println(people);
    }
}