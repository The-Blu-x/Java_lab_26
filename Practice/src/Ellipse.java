public class Ellipse extends Shape{
    private Point center;
    private double rx;
    private double ry;

    public Ellipse(Point center, double rx, double ry, Style style) {
        super(style);
        this.center = center;
        this.rx = rx;
        this.ry = ry;
    }

    @Override
    public String toSvg() {
        return "<ellipse cx=\"" + center.getX() + "\" cy=\"" + center.getY() +
                "\" rx=\"" + rx + "\" ry=\"" + ry + "\" " + style.toSvg() + "/>";
    }

    @Override
    public Polygon.BoundingBox boundingBox() {
        // Lewy górny róg to środek minus promienie
        double minX = center.getX() - rx;
        double minY = center.getY() - ry;
        // Szerokość i wysokość to po prostu średnice
        double width = 2 * rx;
        double height = 2 * ry;

        return new Polygon.BoundingBox(minX, minY, width, height);
    }
}
