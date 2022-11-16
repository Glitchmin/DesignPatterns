package decorator;

public class ColorDecor extends DrawnShapeDecor {
    ColorTypes colorType;

    public ColorDecor(Decorator drawnShape, ColorTypes colorType) {
        super(drawnShape);
        this.colorType = colorType;
        drawShape();
    }

    @Override
    public DrawnShape drawShape() {
        DrawnShape ans = drawnShape.drawShape();
        ans.setColor(colorType);
        return ans;
    }
}
