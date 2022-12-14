package JsonBuilder;

public class Builder {
    CompoundObject object = new CompoundObject();
    Builder append(String name, JsonObject jsonObject){
        object.addJsonObject(name, jsonObject);
        return this;
    }
    CompoundObject buildFinalObject(){
        return object;
    }
}
