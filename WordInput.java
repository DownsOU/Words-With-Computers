package com.mycompany.words_with_computers;
import java.util.Scanner;


public class WordInput {
    
    public String getPlayerInput(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Player Word: ");
        String word = scan.nextLine();
        return word;
    }
    
    public char[] getPlayerInputAsCharArray(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Player Word: ");
        String word = scan.nextLine();
        char[] wordChars = word.toCharArray();
        return wordChars;
    }
    
}
