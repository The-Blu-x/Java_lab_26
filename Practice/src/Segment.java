public class Segment {
    private Point p1;
    private Point p2;

    public Segment(Point p1, Point p2) {
        this.p1 = new Point(p1); // Tworzymy kopię p1
        this.p2 = new Point(p2); // Tworzymy kopię p2
    }
    public Point getP1() { return p1; }
    public Point getP2() { return p2; }

    public double length() {
        return Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) + Math.pow((p2.getY() - p1.getY()), 2));
    }

    public Segment perpendicular() {
        double xMid = (p1.getX() + p2.getX()) / 2.0;
        double yMid = (p1.getY() + p2.getY()) / 2.0;
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();

        Point p1_new = new Point(xMid + dy / 2.0, yMid - dx / 2.0);
        Point p2_new = new Point(xMid - dy / 2.0, yMid + dx / 2.0);

        return new Segment(p1_new, p2_new);
    }

    public static Segment najdluzszy(Segment[] tablica){
        // 1. Zakładamy, że pierwszy odcinek jest najdłuższy (nasz "król góry")
        Segment max = tablica[0];

        // 2. Przechodzimy przez resztę tablicy (zaczynamy od indeksu 1)
        for (int i = 1; i < tablica.length; i++) {
            // Tu musimy sprawdzić, czy kolejny odcinek jest dłuższy od 'max'
            if ( tablica[i].length() > max.length() ){
                max = tablica[i];
            }
        }
        return max;
    }

    @Override
    public String toString(){
        return "Segment[p1=" + p1.toString() + ", p2=" + p2.toString() + "]";
    }
}
