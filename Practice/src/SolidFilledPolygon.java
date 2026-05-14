public class SolidFilledPolygon extends Polygon {
    private String color;

    public SolidFilledPolygon(String color, Vec2[] points) {
        super(points);
        this.color = color;
    }

    @Override
    public String toSvg(String str) {
        // 1. Przygotowujemy napis z kolorem, np. fill="red"
        String fillAttribute = String.format(java.util.Locale.ENGLISH, "fill=\"%s\" %s", color, str);

        // 2. Przekazujemy ten napis "wyżej" do metody toSvg w klasie Polygon
        return super.toSvg(fillAttribute);
    }
}
