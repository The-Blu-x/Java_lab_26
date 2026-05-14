public class SolidFillShapeDecorator extends ShapeDecorator{
    private String color;

    public SolidFillShapeDecorator(String color, Shape decoratedShape){
        super(decoratedShape);
        this.color = color;
    }

    @Override
    public String toSvg(String string) {
        // Formatujemy napis: fill="kolor" dotychczasowe_parametry
        String formattedAttributes = String.format(java.util.Locale.ENGLISH, "fill=\"%s\" %s", color, string);

        // Przekazujemy sformatowany napis do ozdabianej figury
        return decoratedShape.toSvg(formattedAttributes);
    }
}
