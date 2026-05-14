public class Point {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    @Override
    public String toString() {
        return "X to: " + x + " a Y to: " + y;
    }

    public String toSvg() {
        return "<circle cx=\"" + x + "\" cy=\"" + y + "\" r=\"5\" />";
    }

    public void translate(double dx, double dy) {
        this.x = this.x + dx;
        this.y = this.y + dy;
    }

    public Point translated(double dx, double dy) {
        Point nowy = new Point(); // 1. Tworzymy nowy, osobny obiekt
        nowy.x = this.x + dx;
        nowy.y = this.y + dy; // 2. Podpisuje nowe wartości do nowego Point

        return nowy; // 3. Zwracamy gotowy, nowy punkt
    }
}
