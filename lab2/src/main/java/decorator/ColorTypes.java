package decorator;

import javafx.scene.paint.Color;

public enum ColorTypes {
    RED,
    GREEN,
    BLUE;

    public Color getColor() {
        switch (this) {
            case RED -> {
                return new Color(1.0, 0.0, 0.0, 1.0);
            }
            case GREEN -> {
                return new Color(0.0, 1.0, 0.0, 1.0);
            }
            case BLUE -> {
                return new Color(0.0, 0.0, 1.0, 1.0);
            }
        }
        return null;
    }
}
