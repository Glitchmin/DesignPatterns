package JsonBuilder;

import java.io.IOException;

public class World {
    public static void main(String[] args) {
        try {
            JsonFileParser parser = new JsonFileParser("resources/xmpl.json");
            System.out.println(parser.parseJson());


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

