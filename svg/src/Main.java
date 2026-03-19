public class Main {
    public static void main(String[] args) throws IOException {
        Point[] points = new Point[5];
        points[0] = new Point(2.3F, 5.6F);
        points[1] = new Point(10.5F, 12.4F);
        points[2] = new Point(15.4F, 74.2F);
        points[3] = new Point(72.4F, 81.3F);
        points[4] = new Point(162.2F, 51.3F);
        Point[] points2 = new Point[3];
        points2[0] = new Point(30.3F, 45.6F);
        points2[1] = new Point(121.5F, 153.4F);
        points2[2] = new Point(62.4F, 74.2F);
        Polygon polygon = new Polygon(points);
        Polygon polygon2 = new Polygon(points2);
        Polygon polygon3 = new Polygon(new Point[]{
                new Point(4.3F, 7.6F),
                new Point(2.3F, 8.6F),
                new Point(5.3F, 10.6F)
        });
        SvgScene scene=new SvgScene();
        scene.addPolygon(polygon);
        scene.addPolygon(polygon2);
//scene.addPolygon(polygon3);
//svg.addPolygon(polygon3);
        scene.addPolygon(
                Polygon.square(new Segment(
                                new Point(130.0f, 100.0f), new Point(100.0f, 140.0f)),
                        new Style("red", "green", 3.0))
        );
        System.out.println(scene.toSvg());
        scene.save("out.svg");
        Segment segment1=new Segment(new Point(3.0f, 0.0f), new Point(0.0f, 4.0f));
        Segment segment2=segment1.perpendicular();
        System.out.println(segment2);
    }
}