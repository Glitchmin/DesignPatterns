public class Builder {
    FinalObject object;
    void append(String name, JsonObject jsonObject){
        object.addJSON_Object(name, jsonObject);
    }
    FinalObject buildFinalObject(){
        return object;
    }
}
