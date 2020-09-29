package com.mycompany.words_with_computers;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;


public class PlayGame {

    
    public static void main(String[] args) {
              
    // Using fake letter generator class    
    String computerLetters = fakeLetterGenerator.getComputerLetters();
    String playerLetters = fakeLetterGenerator.getPlayerLetters(); 
      
    // Using a swing Gui
    JFrame f = new JFrame();
    
    // Initializing gui elements
    JButton generateButton = new JButton("Generate Letters");
    JButton submitButton = new JButton("Play game");
    JLabel gameTitle = new JLabel("Words With Computers");
    gameTitle.setFont(new Font("Verdana", Font.PLAIN, 18));
    JLabel computerLettersLabel = new JLabel("Computer Letters");
    JLabel playerLettersLabel = new JLabel("Player Letters");
    JTextField textField = new JTextField("Enter Player Word");
    JLabel computerTurn = new JLabel();
    JLabel playerTurn = new JLabel();
    
    // Setbounds method to position and set size of elements, arguments: setBounds(int x-coordinate, int y-coordinate, int width, int height)
    gameTitle.setBounds(80, 20, 300, 30);
    computerLettersLabel.setBounds(100,70, 200,30);
    playerLettersLabel.setBounds(100,120, 200,30); 
    textField.setBounds(90,170, 200,30); 
    computerTurn.setBounds(50,220, 300,30); 
    playerTurn.setBounds(50,270, 300,30);
    generateButton.setBounds(35,400,150, 30);
    submitButton.setBounds(200,400,150, 30);
    
    // Method so textbox doesnt already have cursor in it when the gui opens
    textField.setFocusable(false);
    
    // Generate letters on button click
    generateButton.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
         computerLettersLabel.setText("Computer Letters: " + computerLetters);
         playerLettersLabel.setText("Player Letters: " + playerLetters);
        }  
    });  
    
    // Play game on click
    submitButton.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){
            
           // Get word from text field 
           String playerWord = textField.getText();
           
           // Using fake class methods (fake classes at bottom of the program) to get score array
           Object [] cpuTurn = fakeComputerTurn.playCpu(computerLetters);
           Object [] playerTurnResult = fakePlayerTurn.playPlayer(playerLetters, playerWord);
           
           // Output computer score using fake data array
           computerTurn.setText("Computer played " + cpuTurn[0] + " for " + cpuTurn[1] + " points.");
           
           // Validate player input before outputing player score
           String validateString = String.valueOf(playerTurnResult[0]);
           
           if (validateString.trim().isEmpty() || validateString.trim().contains("Enter Player Word")){
               playerTurn.setText("Player entered invalid word");
           } else {
               playerTurn.setText("Player played " + playerTurnResult[0] + " for " + playerTurnResult[1] + " points.");  
           }
        }  
    });  
     
    
    // Clears text that says "Enter Player Word" and sets cursor in textbox using focus methods
    textField.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            textField.setFocusable(true);
            textField.requestFocus(); 
            textField.setText("");
        }
    }); 
    
    // Adding elements to the Jframe
    f.add(gameTitle);
    f.add(submitButton);
    f.add(generateButton);
    f.add(computerLettersLabel);
    f.add(playerLettersLabel);
    f.add(textField);
    f.add(playerTurn);
    f.add(computerTurn);
    f.setLayout(null);
    f.setVisible(true);
    
    // Method to adjust size of the Gui
    f.setSize(400,500);
   
    
    }
}

  // Fake classes

    class fakeLetterGenerator{
       public static String getComputerLetters(){
           return "kdjryti";
       }
       
       public static String getPlayerLetters(){
           return "yembnde";
       }
   }
    
    // Fake computer turn and player turn classes return Object arrays of word and score for both player and computer
    class fakeComputerTurn{
        public static Object[] playCpu(String letters){
            String cpuWord = "cpu_word";
            Object[] score = {cpuWord, 100};
                return score;
        }
    }

    class fakePlayerTurn{
        public static Object[] playPlayer(String letters, String word){
            Object[] score = {word, 300};
            return score;
        }
    }
   
