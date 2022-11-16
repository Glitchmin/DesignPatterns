package decorator;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public enum ShapeTypes {
    TRIANGLE,
    SQUARE,
    CIRCLE;

    public Shape getShape() {
        switch (this) {
            case TRIANGLE -> {
                Polygon tr = new Polygon();
                tr.getPoints().setAll(40d, 400d, 400d, 400d, 200d, 40d);
                return tr;
            }
            case SQUARE -> {
                Polygon sq = new Polygon();
                sq.getPoints().setAll(40d, 400d, 400d, 400d, 400d, 40d,40d, 40d);
                return sq;
            }
            case CIRCLE -> {
                return new Circle(220d,220d,180);
            }
        }
        return null;
    }
}


