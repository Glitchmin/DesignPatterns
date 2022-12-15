package JsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class JsonFileParser {
    BufferedReader reader;

    JsonFileParser(String path) throws IOException {
        reader = new BufferedReader(path);
    }

    private int nestedObjects = 0;

    void printDebug(Object message) {
        for (int i = 0; i < nestedObjects; i++) {
            System.out.print("  ");
        }
        System.out.println(message);
    }

    JsonObject parseObject() {
        Builder builder = new Builder();
        //do parseKey
        printDebug("{");
        nestedObjects++;
        while (true) {
            Optional<String> key = parseKey();
            if (key.isPresent()) {
                printDebug("key: " + key.get());
                builder.append(key.get(), parseValue());
            } else {
                break;
            }
        }
        nestedObjects--;
        printDebug("}");
        return builder.buildFinalObject();
        // empty => zwróc co masz
        // not em[ty dodaj i parsuj dalej

        //albo zamiast optów if czy " czy }
    }

    JsonObject parseNumber() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        boolean isFloat = false;
        while (Character.isDigit(reader.peek()) || reader.peek() == '.') {
            char c = reader.read();
            if (c == '.') {
                isFloat = true;
            }
            stringBuilder.append(c);
        }
        printDebug((isFloat ? "float: " : "int: ") + stringBuilder);
        return isFloat ?
                new JsonFloat(Float.valueOf(stringBuilder.toString())) :
                new JsonInteger(Integer.valueOf(stringBuilder.toString()));
    }

    JsonString parseString() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        char c = reader.read();
        while (c != '\"') {
            stringBuilder.append(c);
            c = reader.read();
        }

        printDebug(stringBuilder.toString());
        return new JsonString(stringBuilder.toString());
    }

    JsonObject parseValue() {
        //wczytaj i spr czy to 123 czy " czy { i odpal parse nummber / parse string / parseOb

        try {
            char c = reader.peekNoWhitespace();
            StringBuilder valueBuilder = new StringBuilder();
            JsonObject out;
            if (Character.isDigit(c)) {
                out = parseNumber();
            } else if (c == '\"') {
                reader.read();
                out = parseString();
            } else if (c == '{') {
                reader.read();
                out = parseObject();
            } else {
                throw new InputMismatchException("unexpected token in value");
            }


            if (reader.peekNoWhitespace() == ',') {
                reader.read();
            }
            return out;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonInteger(-1);

    }

//    char readNoWhitespace() throws IOException {
//
//        char c = (char) reader.read();
//        while (Character.isWhitespace(c)) {
//            c = (char) reader.read();
//        }
//        return c;
//    }

    Optional<String> parseKey() {
//        spr czy " czy {" i robi parseString a potem : albo ret empty
        try {
            char c = reader.readNoWhitespace();
            if (c == '}') {
                return Optional.empty();
            } else if (c == '"') {
                c = reader.read();
                StringBuilder keyBuilder = new StringBuilder();
                while (c != '"') {
                    keyBuilder.append(c);
                    c = reader.read();
                }
                c = reader.readNoWhitespace();
                if (c != ':') {
                    throw new InputMismatchException(": after key expected, got " + c + " instead");
                }
                return Optional.of(keyBuilder.toString());

            } else {
                throw new InputMismatchException("\" as a start of a key or } as the end of an object expected, got " + c + " instead");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    CompoundObject parseJson() throws IOException {
        Builder builder = new Builder();

        while (reader.readNoWhitespace() != '{') {
        }
        builder.append("", parseObject());
//        for (int i=0; i<5;i++) {
//            System.out.println(parseValue());
//        }

        return builder.buildFinalObject();
    }

}
