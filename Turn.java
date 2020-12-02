package words_with_computers

import net.didion.jwnl.JWNLException;
import java.util.*;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class Turn {
    private int playerScore;
    private int computerScore;
    char[][] boardArray;
        
    ArrayList<String> playerRack = new ArrayList();
    ArrayList<String> cpuRack = new ArrayList();

    Score score = new Score();
    LetterBag letterBag = new LetterBag();
    Player player = new Player();
    PlayComputer computer = new PlayComputer();
    BoardModel boardModel = new BoardModel();
    BoardPlacement boardPlacement = new BoardPlacement(boardModel);

    JFrame frame = new JFrame();
    JPanel boardView = new JPanel();

    public Turn() {}
    
    public int playerTurn(int pScore){
        playerScore = pScore;

        letterBag.fillPlayerLetterRack();
        playerRack = letterBag.getPlayerLetterRack();
        player.giveLetters(playerRack);

        player.displayPlayerCharacters();
        player.letPlayerInput();
        while(player.checkTurn(player.getPlayerInput()) == false) {
            System.out.println("That is not a word, try again.");
            player.letPlayerInput();
        }
        String playerWord = player.getPlayerInput();
        player.inputPlayerPlacement();
        boardPlacement.placePlayer(playerWord, player.getPlayerCoordinates()[0], player.getPlayerCoordinates()[1], player.getPlayerOrientation());
        
        boardArray = boardModel.getBoard();
        boardView = new JPanel(new GridLayout(15, 15));
        boardView.setBounds(240, 100, 400, 400);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                JLabel label = new JLabel(String.valueOf(boardArray[i][j] + "."));
                boardView.add(label);
            }
        }
        frame.add(boardView);
        frame.setVisible(true);
        
        playerScore = score.getPlayerScore();

        return playerScore;
    }
    
    public int computerTurn(int cScore){
        computerScore = cScore;
        
        letterBag.fillComputerLetterRack();
        cpuRack = letterBag.getComputerLetterRack();
        computer.giveLetters(cpuRack);
        
        System.out.println("Computer Letters are: " + cpuRack);
        boardPlacement.placeComputer(computer.playTurn());
        
        boardArray = boardModel.getBoard();
        boardView = new JPanel(new GridLayout(15, 15));
        boardView.setBounds(240, 100, 400, 400);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                JLabel label = new JLabel(String.valueOf(boardArray[i][j] + "."));
                boardView.add(label);
            }
        }
        frame.add(boardView);
        frame.setVisible(true);
        
        computerScore = score.getCPUScore();
        
        return computerScore;
    }
}
