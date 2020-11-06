package com.mycompany.words_with_computers;

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
    
    // Not sure if these work yet
    public boolean adjacentClearHorizontal(int row, int startIndex, int intersection, int length){
        boolean clear = true;
        
        for (int i = startIndex; i < intersection; i++){
            if (getTileUp(row, i) != ' ' || getTileDown(row, i) != ' '){
                clear = false;
            }
        }
        
        for (int j = intersection+1; j < length; j++){
            if (getTileUp(row, j) != ' ' || getTileDown(row, j) != ' '){
                clear = false;
            }
        }
        return clear;
    }

 public boolean adjacentClearVertical(int column, int startIndex, int intersection, int length){
        boolean clear = true;
        
        for (int i = startIndex; i < intersection; i++){
            if (getTileLeft(i, column) != ' ' || getTileRight(i, column) != ' '){
                clear = false;
            }
        }
         for (int j = intersection+1; j < length; j++){
            if (getTileLeft(j, column) != ' ' || getTileRight(j, column) != ' '){
                clear = false;
            }
        }
        return clear;
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