public class StrokeShapeDecorator extends ShapeDecorator {
    private String color;
    private double width;

    public StrokeShapeDecorator(String color, double width, Shape decoratedShape){
        super(decoratedShape);
        this.color = color;
        this.width = width;
    }

    @Override
    public String toSvg(String string) {
        String strokeParams = String.format(java.util.Locale.ENGLISH,
                "stroke=\"%s\" stroke-width=\"%f\" ", color, width);

        return decoratedShape.toSvg(string);
    }

}
