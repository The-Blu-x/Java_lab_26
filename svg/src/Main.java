public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Point point = new Point();
        point.x = 5.6F;
        point.y = 2.4F;
        System.out.println(point);
        System.out.println(point.toSvg());
    }
}
