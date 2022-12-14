import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

public class JsonFileParser {
    FileReader reader;

    JsonFileParser(String path) throws IOException {
        reader = new FileReader(path);
    }

    Scanner scanner = new Scanner(System.in);

    /*JsonObject parseObject() {
        //do parseKey
        // empty => zwróc co masz
        // not em[ty dodaj i parsuj dalej

        //albo zamiast optów if czy " czy }
    }*/

    JsonObject parseNumber(StringBuilder valueBuilder) throws IOException {
        char c = getNoWhitespaceChar();
        boolean isFloat = false;
        while (c != ',') {
            if (c == '.') {
                isFloat = true;
            }
            valueBuilder.append(c);
            c = getNoWhitespaceChar();
        }
        return isFloat ?
                new JsonFloat(Float.valueOf(valueBuilder.toString())) :
                new JsonInteger(Integer.valueOf(valueBuilder.toString()));
    }

    JsonString parseString(StringBuilder valueBuilder) throws IOException{
        char c = getNoWhitespaceChar();
        while (c != ',') {
            valueBuilder.append(c);
            c = getNoWhitespaceChar();
        }
        return new JsonString(valueBuilder.toString());
    }

    JsonObject parseValue() {
        //wczytaj i spr czy to 123 czy " czy { i odpal parse nummber / parse string / parseOb

        try {
            char c = getNoWhitespaceChar();
            StringBuilder valueBuilder = new StringBuilder();
            if (c >= '0' && c <= '9') {
                valueBuilder.append(c);
                return parseNumber(valueBuilder);
            }
            if (c == '\"') {
                return parseString(valueBuilder);
            }
            if (c=='{'){
                return new CompoundObject();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonInteger(-1);

    }

    char getNoWhitespaceChar() throws IOException {

        char c = (char) reader.read();
        while (Character.isWhitespace(c)) {
            c = (char) reader.read();
        }
        return c;
    }

    Optional<String> parseKey() {
//        spr czy " czy {" i robi parseString a potem : albo ret empty
        try {
            char c = getNoWhitespaceChar();
            if (c == '{') {
                return Optional.empty();
            }
            StringBuilder keyBuilder = new StringBuilder();
            while (c != ':') {
                keyBuilder.append(c);
                c = (char) reader.read();
            }
            return Optional.of(keyBuilder.toString());


        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    CompoundObject parseJson() {
        Builder builder = new Builder();

        System.out.println(parseKey());
        for (int i=0; i<5;i++) {
            Optional<String> key = parseKey();
            key.ifPresent(s -> System.out.print(s + ": "));
            System.out.println(parseValue());
        }

        return builder.buildFinalObject();
    }

}
