package words_with_computers;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.ArrayList;
import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.*;
import net.didion.jwnl.data.list.PointerTargetNodeList;
import net.didion.jwnl.dictionary.Dictionary;

public class Player {
    
    private String word;
    private char[] wordChars;
    private ArrayList<Character> letterRack;

    private Dictionary wordnet;

    public Player() {
        configureJWordNet();
        wordnet = Dictionary.getInstance();
        letterRack = new ArrayList();
    }
    
    public void giveLetters(ArrayList<String> letters) {
        for(String s: letters) {
            letterRack.add(s.charAt(0));
        }
    }
    
    public void displayPlayerCharacters() {
        System.out.println("The Players Characters are: " + letterRack);
    }
      
    public void letPlayerInput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter player word: ");
        this.word = scan.nextLine();
    } 
    public String getPlayerInput() {
        return word;
    }

    public char[] getPlayerInputChars() {
        return word.toCharArray();
    }
    
    public boolean checkTurn() throws JWNLException { 
        IndexWord[] wordArray;
        ArrayList<Character> wordPlayedArray = new ArrayList();
        for (int i = 0; i < word.length(); i++) {
            wordPlayedArray.add(word.charAt(i));
        }
        if (letterRack.containsAll(wordPlayedArray)) {
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