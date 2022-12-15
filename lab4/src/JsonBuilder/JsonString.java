package JsonBuilder;

public class JsonString extends JsonObject {
    String string;
    JsonString(String string){
        this.string = string;
    }

    @Override
    public String toString() {
        return "\"" + string + "\"";
    }
}
