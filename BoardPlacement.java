package boardplacement;

public class BoardPlacement {
    
    private BoardModel board;

    public BoardPlacement(BoardModel model) {
        board = model;
    }

    public void placePlayer(String word, int row, int column, String orientation) {
        //check if tiles are clear to place letters
        for (int i = 0; i < word.length(); i++) {
            if (orientation.equalsIgnoreCase("H")) {
                if (board.getTileRight(row, column + i) != ' ' 
                        && board.getTileRight(row, column + i) != word.charAt(i)) {
                    System.out.println("Cannot place here");
                    return;
                }
            }
            if (orientation.equalsIgnoreCase("V")) {
                if (board.getTileDown(row + i, column) != ' '
                        && board.getTileDown(row + i, column) != word.charAt(i)) {
                    System.out.println("Cannot place here");
                    return;
                }
            }
        }
        //place letters on board
        if(orientation.equalsIgnoreCase("H")) {
            for(int i = 0; i < word.length(); i++){
                 board.setTile(row, column + i, word.charAt(i));
            }
        }
        if(orientation.equalsIgnoreCase("V")) {
            for(int i = 0; i < word.length(); i++){
                 board.setTile(row + i, column, word.charAt(i));
            }
        }
    }
    
    public void placeComputer(String word) {
        for(int i = 0; i < board.getBoard().length; i++) {
            for( int j = 0; j < board.getBoard().length; j++) {
                if(word.contains(Character.toString(board.getTile(i,j)))){
                    if(board.getTileLeft(i,j) == ' ' && board.getTileRight(i,j) == ' ') {
                        for(int k =0; k < word.length(); k++) {
                            board.setTile(i, j - word.indexOf(board.getTile(i,j)) + k, word.charAt(k));
                        }
                        return;
                    }
                    if(board.getTileUp(i,j) == ' ' && board.getTileDown(i,j) == ' ') {
                        for(int k =0; k < word.length(); k++) {
                            board.setTile(i - word.indexOf(board.getTile(i,j)) + k, j, word.charAt(k));
                        }
                        return;
                    }
                } 
            }
        }
    }

}
