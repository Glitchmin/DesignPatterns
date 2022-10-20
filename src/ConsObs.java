import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ConsObs extends AbstractObserver {
    public ConsObs(String filename) {
        super(filename);
    }

    @Override
    public void newSentence(String sentence) {
        Integer consCounter = 0;
        Character[] cons =
                {'B', 'C', 'D', 'F', 'G', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'S', 'T', 'V', 'X', 'Z', 'H', 'R', 'W', 'Y',
                        'b', 'c', 'd', 'f', 'g', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 's', 't', 'v', 'x', 'z', 'h', 'r', 'w', 'y'};
        for (char a : sentence.toCharArray()) {
            consCounter += (List.of(cons).contains(a)) ? 1 : 0;
        }
        try {
            fileWriter.append(consCounter.toString());
            fileWriter.append("\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
