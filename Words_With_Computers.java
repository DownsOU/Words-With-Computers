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
        
        ArrayList<String> playerRack = new ArrayList();
        ArrayList<String> cpuRack = new ArrayList();
        playerRack = bag.fillLetterRack();
        cpuRack = bag.fillLetterRack();
        
        cpu.giveLetters(cpuRack);
        player.giveLetters(playerRack);
        
        
        player.displayPlayerCharacters();
        player.letPlayerInput();
        while(player.checkTurn() == false) {
            System.out.println("Sorry that does not follow the rules, please try again");
            player.letPlayerInput();
        }
        String playerWord = player.getPlayerInput();
        
        System.out.println("Player played: " + playerWord);
        
        System.out.println("Computer Letters are: " + cpuRack);
        
        String cpuWord = cpu.playTurn();
        
        System.out.println("Computer Played: " + cpuWord);
        
        score.calculatePlayerScore(playerWord);
        score.calculateCPUScore(cpuWord);
        
        System.out.println("Player Scored: " + score.getPlayerScore());
        System.out.println("Computer Scored: " + score.getCPUScore());
        
        
        
        
        
    }
    
}
