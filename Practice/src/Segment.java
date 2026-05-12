public class Segment {
    public Point p1;
    public Point p2;

    public double length() {
        return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
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
}
