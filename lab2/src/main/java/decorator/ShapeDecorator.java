package decorator;

public class ShapeDecorator extends DrawnShapeDecor {
    protected ShapeTypes shapeType;
    public ShapeDecorator(Decorator drawnShape, ShapeTypes shapeTypes){
        super(drawnShape);
        this.shapeType = shapeTypes;
        drawShape();
    }
    @Override
    public DrawnShape drawShape() {
        DrawnShape ans = drawnShape.drawShape();
        ans.setShape(shapeType);
        return ans;
    }
}
