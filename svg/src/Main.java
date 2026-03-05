public class Main {
    public static void main(String[] args) {
        Point[] points = new Point[5];
        points[0] = new Point(20.4F, 3.5F);
        points[1] = new Point(203.2F, 34.5F);
        points[2] = new Point(430.4F, 50.5F);
        points[3] = new Point(26.2F, 33.7F);
        points[4] = new Point(21.4F, 57.5F);

        Polygon polygon = new Polygon(points);
        System.out.println(polygon);
    }
}
