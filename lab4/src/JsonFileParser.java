import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JsonFileParser {
    FileReader reader;

    JsonFileParser(String path) throws IOException {
        reader = new FileReader(path);
    }

    Scanner scanner = new Scanner(System.in);

    JsonObject parseObject() {
        //do parseKey
        // empty => zwróc co masz
        // not em[ty dodaj i parsuj dalej

        //albo zamiast optów if czy " czy }
    }

    JsonObject parseValue() {
        //wczytaj i spr czy to 123 czy " czy { i odpal parse nummber / parse string / parseOb
    }

    Optional<String> parseKey(){
//        spr czy " czy {" i robi parseString a potem : albo ret empty
    }

    CompoundObject parseJson() {
        Builder builder = new Builder();

        for (int i = 0; i < 10000; i++) {

            System.out.println(scanner.next().charAt(0));
        }

        return builder.buildFinalObject();
    }

}
