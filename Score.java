package words_with_computers;

public class Score{

    private static int pScore;
    private static int cpuScore;
    private String winner;
    
    public Score(){
    //Initializing score variables to 0 when a new class instance is created
        pScore = 0;
        cpuScore = 0;
    }
    
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
                case 'a':
                case 'e':
                case 'i':
                case 'n':
                case 'o':
                case 'r':
                case 't':
                    wrdScore += 1;
                    break;
                //letter is uncommon if there are 3-5 total
                case 'd':
                case 'g':
                case 'l':
                case 's':
                case 'u':
                    wrdScore += 3;
                    break;
                //letter is rare if there are 2 or less total
                case 'b':
                case 'c':
                case 'f':
                case 'h':
                case 'j':
                case 'k':
                case 'm':
                case 'p':
                case 'q':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                case ' ':
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
        String endResults;
        endResults = "Your score: " + pScore + "\nComputer score: " + cpuScore + "\n" + winner;
        return endResults;
    }
}
