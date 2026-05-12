public class Main {
    public static void main(String[] args) {
        // --- TEST ZADANIA 1 i 2 (toString i toSvg) ---
        Point p1 = new Point();
        p1.x = 5.0;
        p1.y = 10.0;

        System.out.println("Test toString: " + p1.toString()); // Powinno wypisać współrzędne
        System.out.println("Test toSvg: " + p1.toSvg());     // Powinno wypisać <circle ... />

        // --- TEST ZADANIA 3 (translate - zmiana w miejscu) ---
        System.out.println("\nPrzesuwamy p1 o (2, -3)...");
        p1.translate(2, -3);
        System.out.println("Po translate: " + p1.toString()); // Powinno być (7.0, 7.0)

        // --- TEST ZADANIA 3 (translated - nowy obiekt) ---
        Point p2 = p1.translated(10, 10);
        System.out.println("\nTest translated:");
        System.out.println("Oryginał p1: " + p1.toString()); // Powinien zostać bez zmian (7.0, 7.0)
        System.out.println("Nowy punkt p2: " + p2.toString()); // Powinien być (17.0, 17.0)

        // --- TEST ZADANIA 4 i 5 (Segmenty i najdłuższy) ---
        Segment s1 = new Segment();
        s1.p1 = p1;
        s1.p2 = p2; // Długość wyniesie ok. 14.14

        Segment s2 = new Segment();
        s2.p1 = new Point(); // (0,0)
        s2.p2 = new Point();
        s2.p2.x = 0; s2.p2.y = 5; // Długość wyniesie 5.0

        Segment[] tablica = {s1, s2};
        Segment wynik = Segment.najdluzszy(tablica);

        System.out.println("\nNajdłuższy segment ma długość: " + wynik.length());
    }
}