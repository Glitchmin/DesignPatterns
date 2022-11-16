package decorator;

public class LineDecorator extends DrawnShapeDecor {
    private final LineTypes lineType;
    public LineDecorator(Decorator drawnShape, LineTypes lineType){
        super(drawnShape);
        this.lineType = lineType;
        drawShape();
    }
    @Override
    public DrawnShape drawShape() {
        DrawnShape ans = drawnShape.drawShape();
        ans.setLine(lineType);
        return ans;
    }
}
