/** Connect4LogicTextConsole Implementation in Java
 *
 * @author Jimmy Anderson
 *
 * @version 2 Build 1 Nov 3, 2024.
 */


package ui;
import core.Connect4Logic;
import core.Connect4ComputerPlayer;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Connect4TextConsole extends Connect4Logic {

    /**
     * Instantiates a new ui.Connect4TextConsole.
     */
// default constructor
    public Connect4TextConsole() {

    }

    /**
     * Main method where we invoke the game
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        char player = 'O';
        Scanner scanner = new Scanner(System.in);
        char[][] grid = new char[6][7];
        Connect4Logic connect = new Connect4Logic();
        Connect4ComputerPlayer computer = new Connect4ComputerPlayer();

        connect.initializeArray(grid);
        connect.drawGrid(grid);

        System.out.println("Begin Game");
        System.out.println("Enter 'P' if you want to play against another player or 'C' if you want to play against a computer");

        while (scanner.hasNextInt()) {
            System.out.println("Please only enter 'P' or 'C' to play the game");
            scanner.next();
        }

        String comp = scanner.next();
        if (comp.equalsIgnoreCase("P")) {
            while (true) {
                // Switch player turn
                player = connect.changeTurn(player);
                System.out.println("Player " + player + " - your turn. Choose a column number from 1 - 7");

                try {
                    int number = scanner.nextInt();
                    // Check if number is between 1 and 7
                    number = connect.checkNumberValue(number);

                    // Validate the move
                    if (connect.validateMove(grid, number)) {
                        connect.dropChip(grid, number, player); // Drop chip on valid move
                        connect.drawGrid(grid); // Draw grid after move

                    } else {
                        System.out.println("Column is full. Try a different column.");
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number between 1 and 7.");
                    scanner.next(); // Clear the invalid input
                    continue;
                }

                // Check for a win
                if (connect.checkWinner(grid, player)) {
                    System.out.println("Player " + player + " has won!");
                    break;
                }

                // Check for a tie if there's no winner
                if (connect.checkTie(grid)) {
                    System.out.println("The game is a tie!");
                    break;
                }
            }
        }else if (comp.equalsIgnoreCase("C")) {
            while (true) {
                player = connect.changeTurn(player);
                System.out.println("Player " + player + " - your turn. Choose a column number from 1 - 7");

                int number = connect.scanner.nextInt();

                // Check if the number is between 1 and 7
                number = connect.checkNumberValue(number);

                // Validate the move
                if (connect.validateMove(grid, number)) {
                    connect.dropChip(grid, number, player);
                    connect.drawGrid(grid);
                } else {
                    System.out.println("Column is full. Try a different column.");
                    continue;
                }

                // Check if the player has won
                if (connect.checkWinner(grid, player)) {
                    System.out.println("Player " + player + " has won!");
                    break;
                }

                // Check for a tie from the player's side
                if (connect.checkTie(grid)) {
                    System.out.println("The game is a tie!");
                    break;
                }

                // Computer's turn
                player = connect.changeTurn(player); // Switch to the computer player
                System.out.println("Computer's turn.");

                Connect4ComputerPlayer.computerMakeMove(grid, player);

                // Check if the computer has won
                if (connect.checkWinner(grid, player)) {
                    System.out.println("Computer has won!");
                    break;
                }

                // Check for a tie after the computer’s move
                if (connect.checkTie(grid)) {
                    System.out.println("The game is a tie!");
                    break;
                }
            }
        }
    }
    public void runGame() {
        main(null);
    }
}