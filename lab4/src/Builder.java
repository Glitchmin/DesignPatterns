public class Builder {
    CompoundObject object = new CompoundObject();
    Builder append(String name, JsonObject jsonObject){
        object.addJSON_Object(name, jsonObject);
        return this;
    }
    CompoundObject buildFinalObject(){
        return object;
    }
}
