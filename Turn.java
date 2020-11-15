package words.with.computers.v1;
import java.util.ArrayList;

public class Turn {
    int playerScore;
    int cpuScore;
    
    Turn(){}
    
    public String playTurn(){
        playerScore = 0;
        cpuScore = 0;
        
        Score score = new Score();
        LetterBag letterBag = new LetterBag();
        Player player = new Player();
        PlayComputer computer = new PlayComputer();
        BoardModel boardModel = new BoardModel();
        BoardPlacementWithoutAdjacent boardPlacement = new BoardPlacementWithoutAdjacent();
        
        //Because the turns take a long time for the computer and because I haven't yet figured out how to end the game when all of the letters are used, we will only have 1 turn for our demo
        
        playerScore = score.calculatePlayerScore(player.getPlayerInput());
        cpuScore = score.calculateCPUScore(computer.getComputerWord());
            
        player.displayPlayerCharacters();
        player.letPlayerInput();
        while (player.checkTurn() == false) {
            System.out.println("That is not a word, try again.");
            player.letPlayerInput();
        }
        String playerWord = player.getPlayerInput();
        player.inputPlayerPlacement();
        BoardPlacement.check(playerWord, player.getPlayerCoordinates()[0], player.getPlayerCoordinates()[1], player.getPlayerOrientation());
        boardModel.displayBoard();
        playerScore = score.calculatePlayerScore(player.getPlayerInput());
        System.out.println("Score:\nPlayer: " + playerScore + "\nComputer: " + cpuScore);
        
        boardPlacement.placeComputer(computer.playTurn());
        boardModel.displayBoard();
        cpuScore = score.calculateCPUScore(computer.getComputerWord());
        System.out.println("Score:\nPlayer: " + playerScore + "\nComputer: " + cpuScore);

        return score.endGameResults();
    }
}