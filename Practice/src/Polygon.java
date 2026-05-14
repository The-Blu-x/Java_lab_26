public class Polygon extends Shape {
    private Point[] points;

    public Polygon(Point[] points, Style style) {
        super(style);

        this.points = new Point[points.length];
        for( int i = 0; i < points.length; i++) {
            this.points[i] = new Point(points[i]);
        }

        if (style == null) {
            this.style = new Style("none", "black", 1.0);
        } else {
            this.style =style;
        }
    }

//    public Polygon(Polygon other) {
//        this.points = other.points; // To jest "płytkie" i ryzykowne
//    }
    public Polygon(Point[] points) {
        this(points, new Style("none", "black", 1.0));
    }

//    public Polygon(Polygon other) {
//        this(other.points);
//    }

    @Override
    public String toString() {
        String result = "Polygon: ";
        for (Point p : points) {
            result += p.toString() + " "; // Wykorzystujemy toString z klasy Point
        }
        return result;
    }

    @Override
    public String toSvg() {
        String s = "<polygon points=\"";
        for (Point p : points) {
            s += p.getX() + "," + p.getY() + " ";
        }
        // Korzystamy ze stylu odziedziczonego po Shape
        s += "\" " + style.toSvg() + "/>";
        return s;
    }

    public static Polygon square(Segment diagonal, Style style) {
        Segment perp = diagonal.perpendicular();

        Point[] points = {
                diagonal.getP1(),
                perp.getP1(),
                diagonal.getP2(),
                perp.getP2()
        };

        return new Polygon(points, style);
    }
    public record BoundingBox(double x, double y, double width, double height) {}

    public BoundingBox boundingBox() {
        double minX = points[0].getX();
        double maxX = points[0].getX();
        double minY = points[0].getY();
        double maxY = points[0].getY();

        for (int i = 1; i < points.length; i++ ){
            double currentX = points[i].getX();
            double currentY = points[i].getY();

            if (currentX < minX) minX = currentX;
            if (currentX > maxX) maxX = currentX;
            if (currentY < minY) minY = currentY;
            if (currentY > maxY) minY = currentY;
        }
        double width = maxX - minX;
        double height = maxY - minY;

        return new BoundingBox(minX, minY, width, height);
    }
}