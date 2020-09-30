package words_with_computers;
import java.util.Scanner;


public class WordInput {
    
    private String word;
    private char[] wordChars;

    public WordInput() {
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
}
