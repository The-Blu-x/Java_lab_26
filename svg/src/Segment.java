public class Segment {
    public Point p, q;
    public float length(){
        return (float) Math.hypot(p.getX() - q.getX(), p.getY() - q.getY());
    }
}
