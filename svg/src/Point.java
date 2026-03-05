import java.util.Locale;

public class Point {
    private float x;
    private float y;
    public Point(Point p){
        this.x=p.getX();
        this.y=p.getY();
    }
    public Point(float x, float y){
        this.x=x;
        this.y=y;
    }

    public Point() {
        this.x=0.0f;
        this.y=0.0f;
    }


    public void setX(float x){
        this.x=x;
    }
    public void setY(float y){
        this.y=y;
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }

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
