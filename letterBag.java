
package words_with_computers;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class letterBag {
    private final int RACKSIZE = 7;
    private ArrayList<String> letterRack;
    private String letterString;
    private char[] letterArr;
    private static ArrayList<String> letterBag;
    Random random;

    public letterBag() {
        this.letterRack = new ArrayList<String>();//Initializing and creating player letter rack.
        this.letterString = "AAAAAAAAABBCCDDDDEEEEEEEEEEEEFFGGGHHIIIIIIIIIJKLLLLMMNNNNNNOOOOOOOOPPQRRRRRRSSSSTTTTTTUUUUVVWWXYYZ__";//Initializing the string that is used to create
        this.letterArr = letterString.toCharArray();//converting string into char array.                                           //the char array that will hold the letters.
        random = new Random();
        this.letterBag = new ArrayList<String>();//Intitializing and creating the letter bag.
        for (char c : letterArr) {
            String s = String.valueOf(c);//Filling the letter bag with all the letters from the char array.
            letterBag.add(s);
        }
    }

    public ArrayList<String> fillLetterRack() {
        int randomIndex;
        String randomChar;
        while (letterRack.size() != RACKSIZE) {//Filling the letter rack until the limit of seven is reached.
            randomIndex = random.nextInt(letterBag.size() + 1);//Creating a random number to reference an index within the bounds of the array.
            randomChar = letterBag.get(randomIndex);//Retrieving the character within the random index of the letter bag and storing it.
            letterBag.remove(randomChar);//Removing that specific letter from the letter bag.
            letterRack.add(randomChar);//Adding that specific letter to the player's letter rack.
        }
        return letterRack;
    }
    public ArrayList<String> getLetterRack() {
        return letterRack;
    }
    public ArrayList<String> getLetterBag() {
        return letterBag;
    }
    public ArrayList<String> exchangeLetters() {//method for exchanging the desired amount of letters(Up to three). After exchanging, returns the updated letterRack that called the method.
        System.out.println("Enter the number of letters you wish to exchange.");
        String exchangeLetter;
        Scanner input = new Scanner(System.in);
        int numOfLetters = input.nextInt();
        int randomIndex;
        String randomChar;
        for (int i=0; i<numOfLetters; i++) {
            System.out.println("Enter the letter you want to exchange.");
            exchangeLetter = input.next();
            letterRack.remove(exchangeLetter);
            letterBag.add(exchangeLetter);
            randomIndex = (int) (Math.random() * letterBag.size());
            randomChar = letterBag.get(randomIndex);
            while (exchangeLetter.equalsIgnoreCase(randomChar)) {//Loop that executes if letter being exhchanged is the same as the new randomly generated one.
                randomIndex = (int) (Math.random() * letterBag.size());// Keeps executing until different letter is retrieved.
                randomChar = letterBag.get(randomIndex);
            }
            letterRack.add(randomChar);
        }
        return letterRack;
    }

}
