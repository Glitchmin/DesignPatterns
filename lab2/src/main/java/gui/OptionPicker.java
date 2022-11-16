package gui;

import decorator.Decorator;
import decorator.DrawnShape;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public abstract class OptionPicker {
    protected final String[] optionNames;
    protected final Label name;
    protected int optionNum;
    protected final Button changeButton;
    protected HBox hBox;
    protected Decorator shape;
    protected App app;

    OptionPicker(){
        optionNames = null;
        name = null;
        changeButton = null;
    }
    OptionPicker(String name, String[] optionNames, Decorator shape, App app){
        this.optionNames = optionNames;
        this.name = new Label(name);
        optionNum = 0;
        changeButton = new Button("change");
        changeButton.setOnAction(actionEvent -> newState());
        this.hBox = new HBox(this.name,new Label(optionNames[optionNum]), changeButton);
        this.shape = shape;
        this.app = app;
    }
    protected abstract void applyChange();
    protected void newState(){
        optionNum++;
        optionNum%=optionNames.length;
        this.hBox.getChildren().clear();
        this.hBox.getChildren().add(name);
        this.hBox.getChildren().add(new Label(optionNames[optionNum]));
        this.hBox.getChildren().add(changeButton);
        applyChange();
        System.out.println(this.shape.drawShape().getShape());
        app.setShape(shape);
        app.draw();

    }
    public HBox getHBox(){
        return hBox;
    }

    public void setShape(Decorator shape) {
        this.shape = shape;
    }
}
