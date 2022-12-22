package JsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class BufferedReader {
    FileReader reader;

    private Optional<Character> buffer = Optional.empty();

    char peek() throws IOException {
        if(buffer.isEmpty()){
            buffer = Optional.of((char) reader.read());
        }
        return buffer.get();
    }

    char peekNoWhitespace() throws IOException {
        while(Character.isWhitespace(peek())){
            read();
        }
        return peek();
    }

    char read() throws IOException {
        if(buffer.isPresent()) {
            char out = buffer.get();
            buffer = Optional.empty();
            return out;
        }
        return (char) reader.read();
    }

    char readNoWhitespace() throws IOException {
        peekNoWhitespace();
        return read();
    }

    BufferedReader(String path) throws FileNotFoundException {
        reader = new FileReader(path);
    }
}
