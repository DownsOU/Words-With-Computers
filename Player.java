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
    private int[] coordinates = new int[2];
    private String playerOrientation;
    private ArrayList<Character> letters = new ArrayList();

    private Dictionary wordnet;
    private BoardModel board;

    Scanner keyboard = new Scanner(System.in);

    public Player() {
        configureJWordNet();
        wordnet = Dictionary.getInstance();
        board = new BoardModel();
    }

    public void giveLetters(ArrayList<String> letterArray) {
        if (letters.isEmpty()) {
            int index = 0;
            for (String s : letterArray) {
                letters.add(index++, s.charAt(0));
            }
        } else {
            int index = 0;
            for (String s : letterArray) {
                letters.set(index++, s.charAt(0));
            }
        }
    }

    public void displayPlayerCharacters() {
        System.out.println("The Players Characters are: " + letters);
    }

    public void letPlayerInput() {
        System.out.println("Enter player word: ");
        this.word = keyboard.nextLine();
    }

    public String getPlayerInput() {
        return word;
    }

    public void inputPlayerPlacement() {
        System.out.println("Enter Row: ");
        coordinates[0] = keyboard.nextInt();
        System.out.println("Enter Column: ");
        coordinates[1] = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Enter Orientation, H for Horizontal, V for Vertical: ");
        playerOrientation = keyboard.nextLine();
    }

    public int[] getPlayerCoordinates() {
        return coordinates;
    }

    public String getPlayerOrientation() {
        return playerOrientation;
    }

    public char[] getPlayerInputChars() {
        return word.toCharArray();
    }

    public boolean checkTurn(String wordPlayed) throws JWNLException {
        IndexWord[] wordArray;
        ArrayList<Character> wordPlayedArray = new ArrayList();
        int match = 0;
        for (int i = 0; i < wordPlayed.length(); i++) {
            wordPlayedArray.add(wordPlayed.charAt(i));
        }
        for(int i = 1; i<wordPlayedArray.size(); i++) {
            if(letters.contains(wordPlayedArray.get(i))) {
                match++;
            }
        }
        if (match == wordPlayedArray.size() -1 ) {
            wordArray = wordnet.lookupAllIndexWords(wordPlayed).getIndexWordArray();
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
