package JsonBuilder;

public class JsonInteger extends JsonObject {
    Integer integer;
    JsonInteger(Integer integer){
        this.integer = integer;
    }

    @Override
    public String toString() {
        return "[int] " + integer;
    }

}
