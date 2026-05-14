public class Main {
    public static void main(String[] args) {
        // Stwórzmy trójkąt
        Point[] trianglePoints = { new Point(10, 10), new Point(150, 10), new Point(80, 120) };
        Polygon triangle = new Polygon(trianglePoints);

        // Stwórzmy scenę i dodajmy figurę
        SvgScene scene = new SvgScene();
        scene.addPolygon(triangle);

        // Zapiszmy do pliku na dysku C lub w folderze projektu
        scene.save("moj_obrazek.svg");
    }
}