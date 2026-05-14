public class ShapeDecorator implements Shape {
    protected Shape decoratedShape;
    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public BoundingBox boundingBox() {
        return decoratedShape.boundingBox();
    }

    @Override
    public String toSvg(String string) {
        // Jak przekazać str dalej do ozdobionego kształtu?
        return decoratedShape.toSvg(string);
    }
}
