package com.mycompany.words_with_computers;

import net.didion.jwnl.JWNLException;
import java.util.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;


public class PlayGame {



    public static void main(String[] args) throws JWNLException {


        JFrame f = new JFrame();
        BoardModel board = new BoardModel();
        BoardPlacement placement = new BoardPlacement(board);
        JLabel gameTitle = new JLabel("Words With Computers");
        gameTitle.setFont(new Font("Verdana", Font.PLAIN, 18));
        JLabel playerScore = new JLabel();
        JLabel computerScore = new JLabel();
        letterBag bag = new letterBag();
        PlayComputer cpu = new PlayComputer();
        Player player = new Player();
        Score score = new Score();
        char[][] boardArray;
        JPanel boardView = new JPanel();
        ArrayList<String> playerRack = new ArrayList();
        ArrayList<String> cpuRack = new ArrayList();

        gameTitle.setBounds(350, 20, 300, 30);
        playerScore.setBounds(200, 50, 300, 30);
        computerScore.setBounds(550, 50, 300, 30);
        f.add(gameTitle);
        f.setLayout(null);
        f.setSize(900, 600);
        f.add(boardView);
        f.setVisible(true);


        for (int i = 0; i < 5; i++) {

            bag.fillComputerLetterRack();
            bag.fillPlayerLetterRack();

            cpuRack = bag.getComputerLetterRack();
            playerRack = bag.getPlayerLetterRack();

            cpu.giveLetters(cpuRack);
            player.giveLetters(playerRack);

            player.displayPlayerCharacters();
            player.letPlayerInput();
            while (player.checkTurn() == false) {
                System.out.println("Sorry that does not follow the rules, please try again");
                player.letPlayerInput();
            }
            String playerWord = player.getPlayerInput();

            player.inputPlayerPlacement();

            placement.placePlayer(playerWord, player.getPlayerCoordinates()[0],
                player.getPlayerCoordinates()[1], player.getPlayerOrientation());
            
            
            // Following code displays latest board model on gui
            boardArray = board.getBoard();
            boardView = new JPanel(new GridLayout(15, 15));
            boardView.setBounds(240, 100, 400, 400);
            for (int j = 0; j < 15; j++) {
                for (int k = 0; k < 15; k++) {
                    JLabel label = new JLabel(String.valueOf(boardArray[j][k] + "."));
                    boardView.add(label);
                }
            }
            f.add(boardView);
            f.setVisible(true);
            //

            
            System.out.println("Computer Letters are: " + cpuRack);
            placement.placeComputer(cpu.playTurn());

            
            boardArray = board.getBoard();
            boardView = new JPanel(new GridLayout(15, 15));
            boardView.setBounds(240, 100, 400, 400);
            for (int j = 0; j < 15; j++) {
                for (int k = 0; k < 15; k++) {
                    JLabel label = new JLabel(String.valueOf(boardArray[j][k] + "."));
                    boardView.add(label);
                }
            }
            f.add(boardView);
            f.setVisible(true);

            
            score.calculatePlayerScore(playerWord);
            if (placement.getPlacedWord().length() > 0) {
                score.calculateCPUScore(placement.getPlacedWord());
            }


            playerScore.setText("Player Scored: " + score.getPlayerScore());
            computerScore.setText("Computer Scored: " + score.getCPUScore());
            f.add(playerScore);
            f.add(computerScore);
            f.setVisible(true);
        }
    }
}