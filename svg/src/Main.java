public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Point point = new Point();
        point.setX(5.6F);
        point.setY(2.4F);
        System.out.println(point.toSvg());
        point.translate(4.3F, 3.4F);
        System.out.println(point.toSvg());
        Point point3=point.translated(7.8F, 2.9F);

        Segment segment = new Segment();
        segment.p = point;
        segment.q = point3;
        System.out.println(segment.length());
    }
}
