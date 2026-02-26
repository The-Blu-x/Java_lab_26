import java.util.Locale;

public class Point {
    public float x;
    public double y;

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    public String toSvg(){
        return String.format(Locale.ENGLISH,"<circle r=\"5\" cx=\"%f\" cy=\"%f\" fill=\"red\" />", this.x, this.y);
    }

    public void translate(float dx, float dy){
        x=x+dx;
        y=y+dy;
    }

    public Point translated(float dx, float dy){
        Point point = new Point();
        point.x=this.x+dx;
        point.y=this.y+dy;
        return point;
    }
}
