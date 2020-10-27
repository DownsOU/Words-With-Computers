package words_with_computers;

public class Score{
    
//    private String pWrd;
//    private String cpuWrd;
    private static int pScore;
    private static int cpuScore;
    private String winner;
    
//    public Score(String playerWord, String computerWord, int playerScore, int computerScore, String win){
//        pWrd = playerWord;
//        cpuWrd = computerWord;
//        pScore = playerScore;
//        cpuScore = computerScore;
//        winner = win;
//    }
    
//    public String getPlayerWord(){
//        return pWrd;
//    }
//    
//    public String getCPUWord(){
//        return cpuWrd;
//    }
    
    public int getPlayerScore() {
        return pScore;
    }
    
    public int getCPUScore() {
        return cpuScore;
    }
    
    private int calculateWordScore(String wrd, int score){
        char[] letters = new char[wrd.length()];
        for (int i = 0; i < wrd.length(); i++) { 
            letters[i] = wrd.charAt(i);
        }
        int wrdScore = score;
        for(int i = 0; i < wrd.length(); i++){
            switch (letters[i]){
                //letter is common if there are 6 or more total
                case 'A':
                case 'E':
                case 'I':
                case 'N':
                case 'O':
                case 'R':
                case 'T':
                    wrdScore += 1;
                    break;
                //letter is uncommon if there are 3-5 total
                case 'D':
                case 'G':
                case 'L':
                case 'S':
                case 'U':
                    wrdScore += 3;
                    break;
                //letter is rare if there are 2 or less total
                case 'B':
                case 'C':
                case 'F':
                case 'H':
                case 'J':
                case 'K':
                case 'M':
                case 'P':
                case 'Q':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                    wrdScore += 5;
            }
        }
        return wrdScore;
    }
    
    public int calculatePlayerScore(String word){
        pScore += calculateWordScore(word, pScore);
        return pScore;
    }
    
    public int calculateCPUScore(String word){
        cpuScore += calculateWordScore(word, cpuScore);
        return cpuScore;
    }
    
    public String determineWinner(){
        if(pScore > cpuScore){
            winner = "You win";  
            }else if(pScore == cpuScore){
                winner = "Tie";        
                }else{
                    winner = "You lose";
        }
        return winner;
    }
    
    public String endGameResults(){
        determineWinner();
        String results;
        results = "Your score: " + pScore + "\nComputer score: " + cpuScore + "\n" + winner;
        return results;
    }
}
