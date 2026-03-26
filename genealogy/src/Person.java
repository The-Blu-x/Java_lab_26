import java.time.LocalDate;

public class Person {
    private String imie;
    private String nazwisko;
    private LocalDate dataUrodzin;
    public Person(String imie, String nazwisko, LocalDate dataUrodzin) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzin = dataUrodzin;
    }
    public String getImie() {
        return imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public LocalDate getDataUrodzin() {
        return dataUrodzin;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + ", ur. " + dataUrodzin;
    }
}
