package words_with_computers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileInputStream;
import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.*;
import net.didion.jwnl.data.list.PointerTargetNodeList;
import net.didion.jwnl.dictionary.Dictionary;

public class Words_With_Computers {

    public static void main(String[] args) throws JWNLException {

        letterBag bag = new letterBag();
        PlayComputer cpu = new PlayComputer();
        Player player = new Player();
        Score score = new Score();
        BoardModel board = new BoardModel();
        BoardPlacement placement = new BoardPlacement(board);

        ArrayList<String> playerRack = new ArrayList();
        ArrayList<String> cpuRack = new ArrayList();
        

        for (int i = 0; i < 5; i++) {
            
            playerRack = bag.fillLetterRack();
            cpuRack = bag.fillLetterRack();
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

            board.displayBoard();

            System.out.println("Computer Letters are: " + cpuRack);

            placement.placeComputer(cpu.playTurn());

            board.displayBoard();

            score.calculatePlayerScore(playerWord);
            if(placement.getPlacedWord().length() > 0) {
                score.calculateCPUScore(placement.getPlacedWord());
            }
            

            System.out.println("Player Scored: " + score.getPlayerScore());
            System.out.println("Computer Scored: " + score.getCPUScore());

        }

    }

}
