package words_with_computers;

import java.util.ArrayList;

public class BoardPlacement {

    private BoardModel board;
    private String placedWord;

    public BoardPlacement(BoardModel model) {
        board = model;
    }

    public void placePlayer(String word, int row, int column, String orientation) {
        //check if tiles are clear to place letters
        if (board.isClear()) {

        }
        for (int i = 0; i < word.length(); i++) {
            if (orientation.equalsIgnoreCase("H")) {
                if (board.getTile(row, column + i) != ' '
                        && board.getTile(row, column + i) != word.charAt(i)) {
                    System.out.println("Cannot place here");
                    return;
                }
            }
            if (orientation.equalsIgnoreCase("V")) {
                if (board.getTile(row + i, column) != ' '
                        && board.getTile(row + i, column) != word.charAt(i)) {
                    System.out.println("Cannot place here");
                    return;
                }
            }
        }
        //place letters on board
        if (orientation.equalsIgnoreCase("H")) {
            for (int i = 0; i < word.length(); i++) {
                board.setTile(row, column + i, word.charAt(i));
            }
        }
        if (orientation.equalsIgnoreCase("V")) {
            for (int i = 0; i < word.length(); i++) {
                board.setTile(row + i, column, word.charAt(i));
            }
        }
    }

    public void placeComputer(ArrayList<String> wordList) {
        for (int i = 0; i < board.getBoard().length; i++) {
            for (int j = 0; j < board.getBoard().length; j++) {
                for (String word : wordList) {
                    placedWord = word;
                    if (word.contains(Character.toString(board.getTile(i, j)))) {
                        if (board.getTileLeft(i, j) == ' ' && board.getTileRight(i, j) == ' '
                                && checkFree(i, j, "H", word)) {
                            System.out.println("placing letters horizontally");
                            for (int k = 0; k < word.length(); k++) {
                                board.setTile(i, j - word.indexOf(board.getTile(i, j)) + k, word.charAt(k));
                            }
                            return;
                        }
                        if (board.getTileUp(i, j) == ' ' && board.getTileDown(i, j) == ' '
                                && checkFree(i, j, "V", word)) {
                            System.out.println("placing letters vertically");
                            for (int k = 0; k < word.length(); k++) {
                                board.setTile(i - word.indexOf(board.getTile(i, j)) + k, j, word.charAt(k));
                            }
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Computer forfeits turn");
    }

    private boolean checkFree(int row, int column, String orientation, String word) {
        if (orientation.equalsIgnoreCase("H")) {
            System.out.println("checking horizontal letters");
            for (int i = 1; i <= word.length(); i++) {
                if ((column - word.indexOf(board.getTile(row, column)) + i) < 0
                        || (column - word.indexOf(board.getTile(row, column)) + i) > 14) {
                    System.out.println("out of bounds horizontally");
                    return false;
                }
            }
            for (int j = 1; j < word.length(); j++) {
                if (board.getTile(row, column + j) != ' '
                        && board.getTile(row, column + j) != word.charAt(j - 1)) {
                    return false;
                }
                if (board.getTileUp(row, (column - word.indexOf(board.getTile(row, column)) + j - 1)) != ' '
                        || board.getTileDown(row, (column - word.indexOf(board.getTile(row, column)) + j - 1)) != ' ') {
                    System.out.println("horizontal adjacent letters not free");
                    return false;
                }
            }
        }
        if (orientation.equalsIgnoreCase("V")) {
            for (int i = 1; i <= word.length(); i++) {
                if ((row - word.indexOf(board.getTile(row, column)) + i) < 0
                        || (row - word.indexOf(board.getTile(row, column)) + i) > 14) {
                    System.out.println("Out of bounds vertically");
                    return false;

                }
            }
            for (int j = 1; j < word.length(); j++) {
                if (board.getTile(row + j, column) != ' '
                        && board.getTile(row + j, column) != word.charAt(j - 1)) {
                    return false;
                }
                if (board.getTileLeft((row - word.indexOf(board.getTile(row, column)) + j), column) != ' '
                        || board.getTileRight((row - word.indexOf(board.getTile(row, column)) + j), column) != ' ') {
                    System.out.println("vertical adjacent letters not free");
                    return false;
                }
            }
        }
        return true;
    }
    
    public String getPlacedWord() {
        return placedWord;
    }

}
