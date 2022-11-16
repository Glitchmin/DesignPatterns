package gui;

import decorator.*;

public class ShapePicker extends OptionPicker {
    ShapePicker(String name, String[] optionNames, Decorator shape, App app){
        super(name,optionNames,shape, app);
    }
    @Override
    protected void applyChange(){
        shape = (new ShapeDecorator(shape, (ShapeTypes.values()[optionNum])));
    }
}
