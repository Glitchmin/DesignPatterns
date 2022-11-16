package decorator;

import decorator.Decorator;

public abstract class DrawnShapeDecor implements Decorator {
    Decorator drawnShape;
    public DrawnShapeDecor(Decorator drawnShape){
        this.drawnShape = drawnShape;
    }

    @Override
    public DrawnShape drawShape() {
        return drawnShape.drawShape();
    }
}
