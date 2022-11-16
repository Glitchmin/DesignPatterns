import java.io.IOException;

public class VowelObs extends AbstractObserver{
    public VowelObs(String filename) {
        super(filename);
    }

    @Override
    public void newSentence(String sentence) {
        Integer vowelCounter = 0;
        for (char a: sentence.toCharArray()){
            vowelCounter += (a=='a' || a=='e'||a=='i'||a =='o' ||a=='u' || a=='A' || a=='E'||a=='I'||a =='O' ||a=='U')?1:0;
        }
        try {
            fileWriter.append(vowelCounter.toString());
            fileWriter.append("\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
