public class Builder {
    FinalObject object = new FinalObject();
    Builder append(String name, JsonObject jsonObject){
        object.addJSON_Object(name, jsonObject);
        return this;
    }
    FinalObject buildFinalObject(){
        return object;
    }
}
