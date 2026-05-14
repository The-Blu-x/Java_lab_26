import java.io.FileWriter;
import java.io.IOException;

public class SvgScene {
    private Polygon[] polygons = new Polygon[3];
    private int index = 0; // Pomocniczy licznik

    public void addPolygon(Polygon p) {
        // 1. Wstaw wielokąt do tablicy pod aktualny index
        polygons[index] = p;

        // 2. Zwiększ index, a jeśli wyniesie 3, zresetuj go do 0
        // Jak byś to zapisał?
        index++;
        if (index >= 3) {
            index = 0;
        }
    }
//    public void addPolygon(Polygon p) {
//        polygons[index] = p;
//        index = (index + 1) % 3; // (0+1)%3=1, (1+1)%3=2, (2+1)%3=0!
//    }
    public String toSvg() {
        String result = "";
        for (int i = 0; i < polygons.length; i++) {
            if (polygons[i] != null) {
                result += polygons[i].toSvg() + "\n";
            }
        }
        return result;
    }
    public void save(String filePath) {
        double totalWidth = 0;
        double totalHeight = 0;

        // 1. Szukamy maksymalnego zasięgu wszystkich wielokątów
        for (Polygon p : polygons) {
            if (p != null) {
                var bbox = p.boundingBox();
                // Sprawdzamy, gdzie kończy się dany wielokąt (start + szerokość)
                totalWidth = Math.max(totalWidth, bbox.x() + bbox.width());
                totalHeight = Math.max(totalHeight, bbox.y() + bbox.height());
            }
        }

        // 2. Składamy nagłówek, treść i stopkę SVG
        String svgStart = String.format(
                "<svg width=\"%f\" height=\"%f\" xmlns=\"http://www.w3.org/2000/svg\">\n",
                totalWidth, totalHeight
        );
        String svgContent = toSvg();
        String svgEnd = "</svg>";

        // 3. Zapis do pliku (używamy try-with-resources, by Java sama zamknęła plik)
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(svgStart);
            writer.write(svgContent);
            writer.write(svgEnd);
            System.out.println("Plik zapisany pomyślnie w: " + filePath);
        } catch (IOException e) {
            System.err.println("Błąd zapisu pliku: " + e.getMessage());
        }
    }
}