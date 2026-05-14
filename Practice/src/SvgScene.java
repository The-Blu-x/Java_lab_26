import java.io.FileWriter;
import java.io.IOException;

public class SvgScene {
    // Zmieniamy na Shape, aby obsługiwać różne figury jednocześnie
    private Shape[] shapes = new Shape[3];
    private int index = 0;

    // Metoda przyjmuje dowolny kształt (Polygon, Ellipse, itp.)
    public void addShape(Shape s) {
        shapes[index] = s;
        index = (index + 1) % shapes.length; // Sprytny licznik (0,1,2,0...)
    }

    public String toSvg() {
        String result = "";
        for (Shape s : shapes) {
            if (s != null) {
                // Wywołuje toSvg() właściwe dla konkretnej klasy (Polygon/Ellipse)
                result += s.toSvg() + "\n";
            }
        }
        return result;
    }

    public void save(String filePath) {
        double totalWidth = 0;
        double totalHeight = 0;

        for (Shape s : shapes) {
            if (s != null) {
                var bbox = s.boundingBox();
                // KLUCZOWA POPRAWKA:
                // Musimy sprawdzić, gdzie figura się KOŃCZY (pozycja + rozmiar)
                double currentRightEdge = bbox.x() + bbox.width();
                double currentBottomEdge = bbox.y() + bbox.height();

                if (currentRightEdge > totalWidth) totalWidth = currentRightEdge;
                if (currentBottomEdge > totalHeight) totalHeight = currentBottomEdge;
            }
        }

        // Pamiętaj o Locale.US, aby uniknąć przecinków!
        String svgStart = String.format(java.util.Locale.US,
                "<svg width=\"%f\" height=\"%f\" xmlns=\"http://www.w3.org/2000/svg\">\n",
                totalWidth, totalHeight
        );

        // ... reszta zapisu ...


        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(svgStart);
            writer.write(toSvg());
            writer.write("</svg>");
            System.out.println("Sukces! Plik zapisany: " + filePath);
        } catch (IOException e) {
            System.err.println("Błąd zapisu: " + e.getMessage());
        }
    }
}