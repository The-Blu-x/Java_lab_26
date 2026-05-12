public class Point {
    public double x;
    public double y;

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
