public class SolidFillShapeDecorator extends ShapeDecorator{
    private final String color;

    public SolidFillShapeDecorator(Shape decoratedShape, String color) {
        super(decoratedShape);
        this.color = color;
    }

    @Override
    public String toSvg() {
        return decoratedShape.toSvg().replace("/>",
                String.format(" fill=\"%s\"/>", color));
    }
}