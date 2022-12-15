package JsonBuilder;

import java.util.LinkedHashMap;


public class CompoundObject extends JsonObject {
    LinkedHashMap<String, JsonObject> map = new LinkedHashMap<>();
    void addJsonObject(String name, JsonObject object){
        map.put(name, object);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{\n");
        for(String key : map.keySet()) {
            stringBuilder.append("\"" + key + "\": " + map.get(key) + "\n");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
