public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(3, 6);
        Point p2 = new Point(2, 7);
        Segment s1 = new Segment(new Point(p1), p2);

        System.out.println(s1);
        p1.setX(5);
        System.out.println(s1);
    }
}
