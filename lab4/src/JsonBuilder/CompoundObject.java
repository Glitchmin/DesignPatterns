package JsonBuilder;

import java.util.HashMap;


public class CompoundObject extends JsonObject {
    HashMap <String, JsonObject> map = new HashMap<>();
    void addJsonObject(String name, JsonObject object){
        map.put(name, object);
    }
}
