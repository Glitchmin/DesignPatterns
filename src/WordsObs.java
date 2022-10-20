import java.io.IOException;

public class WordsObs extends AbstractObserver{
    public WordsObs(String filename) {
        super(filename);
    }

    @Override
    public void newSentence(String sentence) {
        Integer spaceCounter = 0;
        for (char a: sentence.toCharArray()){
            spaceCounter += (a==' ')?1:0;
        }
        try {
            spaceCounter++;
            fileWriter.append(spaceCounter.toString());
            fileWriter.append("\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
