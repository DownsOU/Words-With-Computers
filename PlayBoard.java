package boardplacement;

import java.util.Scanner;

public class PlayBoard {

    public static void main(String[] args) {

        BoardModel board = new BoardModel();
        BoardPlacement placement = new BoardPlacement(board);

        Scanner keyboard = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.println("Player Turn");
            System.out.println("Enter Word:");
            String playerWord = keyboard.nextLine();
            System.out.println("Enter Row: ");
            int playerRow = keyboard.nextInt();
            System.out.println("Enter Column: ");
            int playerColumn = keyboard.nextInt();
            keyboard.nextLine();
            System.out.println("Enter Orientation, H for Horizontal, V for Vertical: ");
            String playerOrientation = keyboard.nextLine();
            placement.placePlayer(playerWord, playerRow, playerColumn, playerOrientation);
            board.displayBoard();
            System.out.println("\n");
            String computerWord = "apple";
            placement.placeComputer(computerWord);
            board.displayBoard();
            
        }
    }
}
