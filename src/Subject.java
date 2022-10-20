import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    List<AbstractObserver> observers = new ArrayList<>();
    FileReader fileReader;
    Subject(String filename){
        try {
            fileReader = new FileReader(filename);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    void addObserver(AbstractObserver observer){
        observers.add(observer);
    }
    void newLine(String sentence){
        for(AbstractObserver obs: observers){
            obs.newSentence(sentence);
        }
    }
    void processText(){
        String sentence = "";
        while(true) {
            try {
                int ans = fileReader.read();
                if (ans == -1){
                    break;
                }
                char c = (char)ans;
                sentence+=c;
                if (c == '.'){
                    newLine(sentence);
                    sentence = "";
                }
                //System.out.println((char)ans);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
