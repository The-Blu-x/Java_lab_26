import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Point[] points = new Point[5];
        points[0] = new Point(2.3F, 5.6F);
        points[1] = new Point(10.5F, 12.4F);
        points[2] = new Point(15.4F, 74.2F);
        points[3] = new Point(72.4F, 81.3F);
        points[4] = new Point(162.2F, 51.3F);
        Point[] points2 = new Point[3];
        points2[0] = new Point(1.3F, 4.6F);
        points2[1] = new Point(8.5F, 12.4F);
        points2[2] = new Point(15.4F, 74.2F);
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
        System.out.println(scene.toSvg());
        scene.save("out.svg");
    }
}