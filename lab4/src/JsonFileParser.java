import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonFileParser {
    FileReader reader;
    JsonFileParser(String path) throws IOException {
        reader = new FileReader(path);
    }


    FinalObject parseJson(){
        Builder builder = new Builder();



        return builder.buildFinalObject();
    }

}
