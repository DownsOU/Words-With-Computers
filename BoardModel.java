package boardplacement;

import java.util.Arrays;

public class BoardModel {

    private final int size = 15;
    private char[][] boardArray = new char[size][size];

    // Create new game board using 2d array
    public BoardModel() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boardArray[i][j] = ' ';
            }
        }
    }

    // Get board array
    public char[][] getBoard() {
        return boardArray;
    }
    
    public int getSize() {
        return size;
    }

    // Set board tile to letter
    public void setTile(int row, int column, char letter) {
        boardArray[row][column] = letter;
    }

    // Get tile at index
    public char getTile(int row, int column) {
        return boardArray[row][column];
    }

    // Get tile above index
    public char getTileUp(int row, int column) {
        return boardArray[row - 1][column];
    }

    // Get tile below index
    public char getTileDown(int row, int column) {
        return boardArray[row + 1][column];
    }

    // Get tile left of index
    public char getTileLeft(int row, int column) {
        return boardArray[row][column - 1];
    }

    // Get tile rigt of index
    public char getTileRight(int row, int column) {
        return boardArray[row][column + 1];
    }


    // Check if board is empty
    public boolean isClear() {
        boolean clear = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (boardArray[i][j] != ' ') {
                    clear = false;
                }
            }
        }
        return clear;
    }

    // Clear the board
    public void clearBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boardArray[i][j] = ' ';
            }
        }
    }

    public void displayBoard() {
        for (char[] i : boardArray) {
            for (char j : i) {
                System.out.print(j + ",");
            }
            System.out.println();
        }
    }
}
