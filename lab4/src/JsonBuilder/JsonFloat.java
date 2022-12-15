package JsonBuilder;

public class JsonFloat extends JsonObject{
    Float own_float;
    JsonFloat(Float own_float){
        this.own_float = own_float;
    }

    @Override
    public String toString() {
        return "[float] " + own_float;
    }
}
