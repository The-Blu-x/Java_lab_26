public class Segment {
    private Point p, q;
    public Segment(Point p, Point q){
        this.p=p;
        this.q=q;
    }

    public Point getP1(){
        return p;
    }
    public Point getP2(){
        return q;
    }

    public Segment perpendicular(){
        float x1=p.getX();
        float x2= q.getX();
        float y1=p.getY();
        float y2= q.getY();
        float midX=(x1+x2)/2.0f;
        float midY=(y1+y2)/2.0f;
        float dx=(x2-x1)/2.0f;
        float dy=(y2-y1)/2.0f;
        Point p3=new Point(midX-dy, midY+dx);
        Point p4= new Point(midX+dy, midY-dx);
        return new Segment(p3, p4);
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
