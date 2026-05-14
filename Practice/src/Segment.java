public class Segment {
    private Point p1;
    private Point p2;

    public Segment(Point p1, Point p2) {
        this.p1 = new Point(p1); // Tworzymy kopię p1
        this.p2 = new Point(p2); // Tworzymy kopię p2
    }
    public double length() {
        return Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) + Math.pow((p2.getY() - p1.getY()), 2));
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
