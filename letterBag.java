package words_with_computers;

import java.util.*;

public class letterBag {

    private final int RACKSIZE = 7;
    private ArrayList<String> playerLetterRack;
    private ArrayList<String> computerLetterRack;
    private String letterString;
    private char[] letterArr;
    private static ArrayList<String> letterBag;

    public letterBag() {
        this.playerLetterRack = new ArrayList<String>();
        this.computerLetterRack = new ArrayList<String>();//Initializing and creating player letter rack.
        this.letterString = "AAAAAAAAABBCCDDDDEEEEEEEEEEEEFFGGGHHIIIIIIIIIJKLLLLMMNNNNNNOOOOOOOOPPQRRRRRRSSSSTTTTTTUUUUVVWWXYYZ";//Initializing the string that is used to create
        this.letterArr = letterString.toCharArray();//converting string into char array.                                           //the char array that will hold the letters.
        this.letterBag = new ArrayList<String>();//Intitializing and creating the letter bag.
        for (char c : letterArr) {
            String s = String.valueOf(c);//Filling the letter bag with all the letters from the char array.
            letterBag.add(s);
        }
        Collections.shuffle(letterBag);
    }

    public void fillPlayerLetterRack() {
        int randomIndex;
        String randomChar;
        while (playerLetterRack.size() != RACKSIZE) {//Filling the letter rack until the limit of seven is reached.
            randomIndex = (int) (Math.random() * letterBag.size());//Creating a random number to reference an index within the bounds of the array.
            randomChar = letterBag.get(randomIndex);//Retrieving the character within the random index of the letter bag and storing it.
            letterBag.remove(randomChar);//Removing that specific letter from the letter bag.
            playerLetterRack.add(randomChar);//Adding that specific letter to the player's letter rack.
        }
    }

    public void fillComputerLetterRack() {
        int randomIndex;
        String randomChar;
        while (computerLetterRack.size() != RACKSIZE) {//Filling the letter rack until the limit of seven is reached.
            randomIndex = (int) (Math.random() * letterBag.size());//Creating a random number to reference an index within the bounds of the array.
            randomChar = letterBag.get(randomIndex);//Retrieving the character within the random index of the letter bag and storing it.
            letterBag.remove(randomChar);//Removing that specific letter from the letter bag.
            computerLetterRack.add(randomChar);//Adding that specific letter to the player's letter rack.
        }
    }

    public ArrayList<String> getPlayerLetterRack() {
        return playerLetterRack;
    }

    public ArrayList<String> getComputerLetterRack() {
        return computerLetterRack;
    }

    public ArrayList<String> getLetterBag() {
        return letterBag;
    }

    public void exchangePlayerLetters() {
//        System.out.println("Enter the number of letters you wish to exchange.");
//        String exchangeLetter;
//        Scanner input = new Scanner(System.in);
//        int numOfLetters = input.nextInt();
//        int randomIndex;
//        String randomChar;
//        for (int i = 0; i < numOfLetters; i++) {
//            System.out.println("Enter the letter you want to exchange.");
//            exchangeLetter = input.next().toUpperCase();
//            playerLetterRack.remove(exchangeLetter);
//            letterBag.add(exchangeLetter);
//            randomIndex = (int) (Math.random() * letterBag.size());
//            randomChar = letterBag.get(randomIndex);
//            while (exchangeLetter.equalsIgnoreCase(randomChar)) {
//                randomIndex = (int) (Math.random() * letterBag.size());
//                randomChar = letterBag.get(randomIndex);
//            }
//            playerLetterRack.add(randomChar);
//        }
//        return playerLetterRack;
        for (int i = 0; i < playerLetterRack.size(); i++) {
            playerLetterRack.remove(i);
        }

        int randomIndex;
        String randomChar;
        while (playerLetterRack.size() != RACKSIZE) {//Filling the letter rack until the limit of seven is reached.
            randomIndex = (int) (Math.random() * letterBag.size());//Creating a random number to reference an index within the bounds of the array.
            randomChar = letterBag.get(randomIndex);//Retrieving the character within the random index of the letter bag and storing it.
            letterBag.remove(randomChar);//Removing that specific letter from the letter bag.
            playerLetterRack.add(randomChar);//Adding that specific letter to the player's letter rack.
        }
    }

    public void exchangeComputerLetters() {
        for (int i = 0; i < computerLetterRack.size(); i++) {
            computerLetterRack.remove(i);
        }

        int randomIndex;
        String randomChar;
        while (playerLetterRack.size() != RACKSIZE) {//Filling the letter rack until the limit of seven is reached.
            randomIndex = (int) (Math.random() * letterBag.size());//Creating a random number to reference an index within the bounds of the array.
            randomChar = letterBag.get(randomIndex);//Retrieving the character within the random index of the letter bag and storing it.
            letterBag.remove(randomChar);//Removing that specific letter from the letter bag.
            playerLetterRack.add(randomChar);//Adding that specific letter to the player's letter rack.
        }
    }

    public void swapPlayerLetters(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (playerLetterRack.contains(word.substring(i, i + 1))) {
                playerLetterRack.remove(word.substring(i, i + 1));
                //System.out.println("removing player letters");
            }
        }
        int randomIndex;
        String randomChar;
        while (playerLetterRack.size() != RACKSIZE) {//Filling the letter rack until the limit of seven is reached.
            randomIndex = (int) (Math.random() * letterBag.size());//Creating a random number to reference an index within the bounds of the array.
            randomChar = letterBag.get(randomIndex);//Retrieving the character within the random index of the letter bag and storing it.
            letterBag.remove(randomChar);//Removing that specific letter from the letter bag.
            playerLetterRack.add(randomChar);//Adding that specific letter to the player's letter rack.
        }
    }

    public void swapComputerLetters(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (computerLetterRack.contains(word.substring(i, i + 1))) {
                computerLetterRack.remove(word.substring(i, i + 1));
                //System.out.println("removing computer letters");
            }
        }
        int randomIndex;
        String randomChar;
        while (computerLetterRack.size() != RACKSIZE) {//Filling the letter rack until the limit of seven is reached.
            randomIndex = (int) (Math.random() * letterBag.size());//Creating a random number to reference an index within the bounds of the array.
            randomChar = letterBag.get(randomIndex);//Retrieving the character within the random index of the letter bag and storing it.
            letterBag.remove(randomChar);//Removing that specific letter from the letter bag.
            computerLetterRack.add(randomChar);//Adding that specific letter to the player's letter rack.
        }
    }

}
