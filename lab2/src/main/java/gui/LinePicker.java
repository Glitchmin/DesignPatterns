package gui;

import decorator.*;

public class LinePicker extends OptionPicker {
    LinePicker(String name, String[] optionNames, Decorator shape, App app){
        super(name,optionNames,shape, app);
    }
    @Override
    protected void applyChange(){
        shape = (new LineDecorator(shape, LineTypes.values()[optionNum]));
    }
}
