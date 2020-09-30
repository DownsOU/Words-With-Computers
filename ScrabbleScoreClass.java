package scrabble.score.pkgclass;

import java.util.Scanner;

//This was used for debugging purposes. Code will be modified so the Score class takes info from other classes rather than this main class
public class ScrabbleScoreClass {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Type a word");
        String playerWord = scan.nextLine();
        Score scrabble = new Score(playerWord, "null", 0, 0, "null");
        System.out.println("You played the word " + scrabble.getPlayerWord() + "\nComputer played the word " + scrabble.getCPUWord());
        scrabble.calculatePlayerScore();
        scrabble.calculateCPUScore();
        System.out.println(scrabble.endGameResults());
    }
}
