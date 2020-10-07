package playercheck;

import java.util.ArrayList;
import java.io.FileInputStream;
import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.*;
import net.didion.jwnl.data.list.PointerTargetNodeList;
import net.didion.jwnl.dictionary.Dictionary;

public class CheckPlayer {

    private ArrayList<Character> letterRack;
    private String word;

    private Dictionary wordnet;

    public CheckPlayer() {
        configureJWordNet();
        wordnet = Dictionary.getInstance();
    }

    public boolean check(ArrayList<Character> rack, String wordPlayed) throws JWNLException { 
        letterRack = rack;
        word = wordPlayed;
        IndexWord[] wordArray;
        ArrayList<Character> wordPlayedArray = new ArrayList();
        for (int i = 0; i < word.length(); i++) {
            wordPlayedArray.add(word.charAt(i));
        }
        if (rack.containsAll(wordPlayedArray)) {
            wordArray = wordnet.lookupAllIndexWords(word).getIndexWordArray();
            if (wordArray.length != 0) {
                return true;
            }
        }
        return false;
    }

    private void configureJWordNet() {
        try {
            JWNL.initialize(new FileInputStream("C:\\Users\\david\\Documents\\NetBeansProjects\\Words-With-Computers\\Words_With_Computers\\file_properties.xml"));
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
    }

}
