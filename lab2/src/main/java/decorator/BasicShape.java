package decorator;

import javafx.scene.paint.Color;

public class BasicShape implements Decorator {
    DrawnShape drawnShape = new DrawnShape();
    @Override
    public DrawnShape drawShape() {

        return drawnShape;
    }
}
