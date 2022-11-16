package decorator;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;


public class DrawnShape {
    private Shape shape = ShapeTypes.TRIANGLE.getShape();
    private ColorTypes colorType = ColorTypes.BLUE;
    private LineTypes lineType = LineTypes.SOLID;


    public void setColor(ColorTypes colorType) {
        this.colorType = colorType;
    }

    public Shape getShape() {
        apply();
        return shape;
    }

    private void apply(){
        this.shape.setStroke(colorType.getColor());
        this.shape.getStrokeDashArray().clear();
        this.shape.getStrokeDashArray().addAll(lineType.getDashArray());
        this.shape.setStrokeWidth(2.0);

        shape.setFill(new Color(0,0,0,0));
    }

    public void setShape(ShapeTypes shapeType) {
        this.shape = shapeType.getShape();
    }
    public void setLine(LineTypes lineType) {
        this.lineType = lineType;
    }
}
