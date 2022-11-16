package decorator;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.lang.reflect.Array;
import java.util.ArrayList;

public enum LineTypes {
    SOLID,
    DOTTED,
    DASHED;
    public ArrayList<Double> getDashArray(){
        ArrayList<Double> tmp = new ArrayList<>();
        switch (this) {
            case SOLID -> {
                tmp.add(10000d);
                return tmp;
            }
            case DOTTED -> {
                tmp.add(2d);
                tmp.add(4d);
                return tmp;
            }
            case DASHED -> {
                tmp.add(15d);
                tmp.add(5d);
                return tmp;
            }
        }
        return null;
    }
}
