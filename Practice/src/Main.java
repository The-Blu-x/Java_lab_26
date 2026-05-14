import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Polygon triangle = new Polygon(new Vec2[]{
                new Vec2(0, 0),
                new Vec2(300, 0),
                new Vec2(150, 250)
        });

        Polygon rectangle = new Polygon(new Vec2[]{
                new Vec2(350, 0),
                new Vec2(750, 0),
                new Vec2(750, 200),
                new Vec2(350, 200)
        });

        Polygon pentagon = new Polygon(new Vec2[]{
                new Vec2(0, 260),
                new Vec2(100, 460),
                new Vec2(300, 560),
                new Vec2(500, 460),
                new Vec2(600, 260)
        });

        // Pierwsza elipsa - bez dekoratorów
        Shape ellipse1 = new Ellipse(new Vec2(500, 700), 400, 100);

        SvgScene scene = new SvgScene();
        scene.addShape(triangle);
        scene.addShape(rectangle);
        scene.addShape(pentagon);
        scene.addShape(ellipse1);

        // --- TEST DEKORATORÓW ---

        // 1. Tworzymy drugą, bazową elipsę (używamy innej nazwy zmiennej!)
        Shape ellipse2 = new Ellipse(new Vec2(100, 100), 50, 30);

        // 2. Ozdabiamy ją kolorem (Zadanie 2)
        // Uwaga: Twoja klasa SolidFillShapeDecorator przyjmuje (String color, Shape decoratedShape)
        ellipse2 = new SolidFillShapeDecorator("red", ellipse2);

        // 3. Ozdabiamy obramowaniem (Zadanie 3)
        // Uwaga: Twoja klasa StrokeShapeDecorator przyjmuje (String color, double width, Shape decoratedShape)
        ellipse2 = new StrokeShapeDecorator("blue", 2.0, (ShapeDecorator) ellipse2);

        // 4. Dodajemy transformacje za pomocą Buildera (Zadanie 4)
        ellipse2 = new TransformationDecorator.Builder()
                .rotate(45, new Vec2(100, 100))
                .translate(new Vec2(50, 0))
                .build(ellipse2);

        // 5. Dodajemy ozdobioną elipsę do sceny
        scene.addShape(ellipse2);

        scene.save("result.svg");
    }
}