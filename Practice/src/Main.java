public class Main {
    public static void main(String[] args) {
        // --- Zadanie 1: Style ---
        Style redStyle = new Style("red", "black", 2.0);
        Style greenStyle = new Style("green", "darkgreen", 5.0);
        Style blueStyle = new Style("none", "blue", 1.0); // Przezroczysty środek

        // --- Zadanie 1 & 4: Wielokąt (Trójkąt) ---
        Point[] trianglePoints = { new Point(10, 10), new Point(110, 10), new Point(60, 110) };
        Polygon triangle = new Polygon(trianglePoints, redStyle);

        // --- Zadanie 2: Kwadrat z przekątnej (Metoda statyczna) ---
        Segment diag = new Segment(new Point(200, 200), new Point(300, 300));
        Polygon square = Polygon.square(diag, blueStyle);

        // --- Zadanie 4: Elipsa ---
        Ellipse ellipse = new Ellipse(new Point(400, 150), 80, 50, greenStyle);

        // --- Zadanie 5 & 6: Scena i Polimorfizm ---
        SvgScene scene = new SvgScene();

        // Dodajemy różne figury do tej samej metody addShape!
        scene.addShape(triangle);
        scene.addShape(square);
        scene.addShape(ellipse);

        // --- Zadanie 8: Zapis do pliku ---
        scene.save("wynik.svg");
    }
}