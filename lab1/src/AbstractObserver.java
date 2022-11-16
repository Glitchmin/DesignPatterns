import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class AbstractObserver {
    File file;
    FileWriter fileWriter;
    public AbstractObserver(String filename){
        file = new File(filename);
        try {
            fileWriter = new FileWriter(filename);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    abstract void newSentence(String sentence);
}
