import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class World {
    public static void main(String[] args) {
        Subject subject = new Subject("C:\\Users\\Adam\\Documents\\Studia\\DesignPatterns\\test_file.txt");
        subject.addObserver(new WordsObs("C:\\Users\\Adam\\Documents\\Studia\\DesignPatterns\\out_words.txt"));
        subject.addObserver(new VowelObs("C:\\Users\\Adam\\Documents\\Studia\\DesignPatterns\\out_vow.txt"));
        subject.addObserver(new ConsObs("C:\\Users\\Adam\\Documents\\Studia\\DesignPatterns\\out_cons.txt"));
        subject.addObserver(new FlipperObs("C:\\Users\\Adam\\Documents\\Studia\\DesignPatterns\\out_flip.txt"));
        subject.processText();


    }
}
