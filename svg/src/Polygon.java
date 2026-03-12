import java.util.Arrays;
import java.util.Locale;

public class Polygon {

    private Point [] points;

    public Polygon(Point[] points) {
        this.points=new Point[points.length];

        for(int i=0; i< points.length; ++i) {
            this.points[i] = new Point(points[i]);
        }
        //System.arraycopy(points, 0, this.points, 0, points.length);
    }
    public Polygon(Polygon p){
        this(p.points);
    }

    @Override
    public String toString() {
        return "Polygon{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
    //<polygon points="100,10 150,190 50,190" style="fill:lime;stroke:purple;stroke-width:3" />
    public String toSvg(){
        StringBuilder pointString = new StringBuilder();
        for (Point point: points){
            pointString.append(point.getX()).append(",").append(point.getY()).append(" ");
        }
        return String.format(Locale.ENGLISH, "<polygon points=\"%s\" style=\"fill:lime;stroke:purple;stroke-width:3\" />", pointString);
    }
}