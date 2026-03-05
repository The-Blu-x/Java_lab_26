public class Segment {
    private Point p, q;
    public Segment(Point p, Point q){
        this.p=p;
        this.q=q;
    }

    @Override
    public String toString() {
        return "Segment{" +
                "p=" + p +
                ", q=" + q +
                '}';
    }


    public float length(){
        return (float) Math.hypot(p.getX() - q.getX(), p.getY() - q.getY());
    }
}
