
package words_with_computers;

import java.util.ArrayList;
import java.util.Random;


public class letterBag {
    private final int RACKSIZE = 7;
    private ArrayList<Character> playerLetterRack;
    private String letterString;
    private char[] letterArr;
    private static ArrayList<Character> letterBag;
    Random random;
    
    public letterBag() {
        this.playerLetterRack = new ArrayList<Character>();//Initializing and creating player letter rack.
        this.letterString = "AAAAAAAAABBCCDDDDEEEEEEEEEEEEFFGGGHHIIIIIIIIIJKLLLLMMNNNNNNOOOOOOOOPPQRRRRRRSSSSTTTTTTUUUUVVWWXYYZ__";//Initializing the string that is used to create
        this.letterArr = letterString.toCharArray();//converting string into char array.                                           //the char array that will hold the letters. 
        random = new Random();
        this.letterBag = new ArrayList<Character>();//Intitializing and creating the letter bag.
        for (char c : letterArr) {//Filling the letter bag with all the letters from the char array.
            letterBag.add(c);
        }
    }
    
    public ArrayList<Character> fillLetterRack() {
        int randomIndex;
        char randomChar;
        while (playerLetterRack.size() != RACKSIZE) {//Filling the letter rack until the limit of seven is reached.
            randomIndex = random.nextInt(letterBag.size() + 1);//Creating a random number to reference an index within the bounds of the array.
            randomChar = letterBag.get(randomIndex);//Retrieving the character within the random index of the letter bag and storing it. 
            letterBag.remove(randomIndex);//Removing that specific letter from the letter bag.
            playerLetterRack.add(randomChar);//Adding that specific letter to the player's letter rack.
        }
        return playerLetterRack;
    }
    public ArrayList<Character> getLetterRack() {
        return playerLetterRack;
    }
    public ArrayList<Character> getLetterBag() {
        return letterBag;
    }
    
}
