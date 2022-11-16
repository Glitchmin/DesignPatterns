import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlipperObs extends AbstractObserver {
    public FlipperObs(String filename) {
        super(filename);
    }

    @Override
    public void newSentence(String sentence) {
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (char a : sentence.toCharArray()) {
            if (a == ' ' || a == '\n' || a == '.' || a == ',' || a == '!' || a == '?') {
                word.reverse();
                if (!word.isEmpty()) {
                    words.add(word.toString());
                }
                word = new StringBuilder();
            } else {
                word.append(a);
            }
        }
        try {
            for (String ans : words) {
                fileWriter.append(ans + " ");
            }
            fileWriter.append("\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
