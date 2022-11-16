package gui;

import decorator.ColorDecor;
import decorator.ColorTypes;
import decorator.Decorator;
import decorator.DrawnShape;
import javafx.scene.paint.Color;

public class ColorPicker extends OptionPicker {
    ColorPicker(String name, String[] optionNames, Decorator shape, App app){
        super(name,optionNames,shape, app);
    }
    @Override
    protected void applyChange(){
        shape = (new ColorDecor(shape, (ColorTypes.values()[optionNum])));
    }
}
