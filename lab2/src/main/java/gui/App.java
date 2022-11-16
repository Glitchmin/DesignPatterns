package gui;

import decorator.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class App extends Application {
    private final GridPane gridPane = new GridPane();
    private final Canvas canva = new Canvas(600, 600);
    Decorator shape = null;
    Shape prevShape = null;
    ColorPicker colorPick;
    LinePicker linePick;
    ShapePicker shapePick;

    public void draw() {

        if (prevShape != null) {
            gridPane.getChildren().remove(prevShape);
        }

        prevShape = shape.drawShape().getShape();
        gridPane.add(prevShape,0,0);

        colorPick.setShape(shape);
        linePick.setShape(shape);
        shapePick.setShape(shape);

        System.out.println(shape);
    }

    public void setShape(Decorator shape) {
        this.shape = shape;
    }

    public void start(Stage primaryStage) {
        shape = new ColorDecor(
                new ShapeDecorator(new LineDecorator(new BasicShape(), LineTypes.SOLID),ShapeTypes.TRIANGLE),
        ColorTypes.RED);
        colorPick = new ColorPicker("color: ", new String[]{"red", "green", "blue"},shape, this);
        linePick = new LinePicker("line style: ", new String[]{"solid", "dotted", "dashed"}, shape,this);
        shapePick = new ShapePicker("shape: ", new String[]{"triangle", "square", "circle"},shape,this);
        Scene scene = new Scene(gridPane, 800, 800);
        primaryStage.setScene(scene);
        gridPane.add(new VBox(colorPick.getHBox(), linePick.getHBox(),shapePick.getHBox()), 1, 0);
        gridPane.add(canva, 0, 0);
        draw();
        primaryStage.show();

    }
}
