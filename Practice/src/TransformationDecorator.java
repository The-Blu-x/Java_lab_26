public class TransformationDecorator extends ShapeDecorator {
    private String transform;

    public TransformationDecorator(Shape decoratedShape, String transform){
        super(decoratedShape);
        this.transform = transform;
    }
    @Override
    public String toSvg(String str) {
        // Przygotowujemy atrybut transform="..."
        String transformAttr = String.format(java.util.Locale.ENGLISH, "transform=\"%s\" ", transform);

        // Przekazujemy go dalej do ozdobionej figury
        return decoratedShape.toSvg(transformAttr + str);
    }

    public static class Builder {
        private String transform = ""; // Pusty napis na start

        public Builder translate(Vec2 translation) {
            // Dodajemy instrukcję translate(x, y)
            transform += String.format(java.util.Locale.ENGLISH, "translate(%f, %f) ",
                    translation.x(), translation.y());
            return this;
        }

        public Builder rotate(double angle, Vec2 center) {
            // Dodajemy instrukcję rotate(kąt, cx, cy)
            transform += String.format(java.util.Locale.ENGLISH, "rotate(%f, %f, %f) ",
                    angle, center.x(), center.y());
            return this;
        }

        public Builder scale(Vec2 scaleFactor) {
            // Dodajemy instrukcję scale(sx, sy)
            transform += String.format(java.util.Locale.ENGLISH, "scale(%f, %f) ",
                    scaleFactor.x(), scaleFactor.y());
            return this;
        }

        public TransformationDecorator build(Shape shape) {
            // Tworzymy gotowy dekorator dla podanej figury
            return new TransformationDecorator(shape, transform.trim());
        }
    }
}
