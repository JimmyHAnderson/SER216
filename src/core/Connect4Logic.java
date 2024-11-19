/** Connect4Logic Implementation in Java
 *
 * @author Jimmy Anderson
 *
 * @version 2 Build 1 Nov 3, 2024.
 */
package core;
import java.util.Scanner;
public class Connect4Logic {
    private static final char BAR = '|';
    protected static final char SPACE = ' ';
    private static int row;
    private static int col;

    /**
     * Instantiate a new Scanner class.
     */

    public static Scanner scanner = new Scanner(System.in);

    /**
     * Instantiates a new Connect 4 match.
     */

// default constructor
    public Connect4Logic() {
    }

    /**
     * Changes the player after they play their turn
     *
     * @param player the player
     * @return char consisting of X or O
     */
    public char changeTurn(char player){
        if(player == 'X'){
            player = 'O';
        }else if(player == 'O'){
            player = 'X';
        }
        return player;
    }


    /**
     * Checks the number to make sure the user
     * is between 1 and 7
     *
     * @param number the number
     * @return the int
     */
    public static int checkNumberValue(int number) {
        boolean checkNumber = true;
        if (number < 1 || number > 7) {
            while (checkNumber) {
                System.out.println("Please choose a number between 1 - 7");
                number = scanner.nextInt();
                if (number > 0 && number < 8) {
                    checkNumber = false;
                }
            }
        }
        return number;
    }

    /**
     * Places an X or O depending on what column the
     * player chooses.
     *
     * @param grid   the grid
     * @param number the number
     * @param player the player
     */
    public void dropChip(char[][] grid, int number, char player){
        for (int row = grid.length -1; row >=0  ; row--) {
            if(grid[row][number -  1] == SPACE){
                grid[row][number - 1] = player;
                break;
            }
        }
    }

    /**
     * Draws grid for the UI using a nested for loop.
     *
     * @param grid the grid
     */
    public static void drawGrid(char[][] grid) {
        for (row = 0; row < grid.length; row++) {
            System.out.print(BAR);
            for (col = 0; col < grid[0].length; col++) {
                System.out.print(grid[row][col]);
                System.out.print(BAR);
            }
            System.out.println();
        }
    }

    /**
     * Initialize array for the UI using a nested for loop.
     *
     * @param grid the grid
     */
    public void initializeArray(char[][] grid) {
        for (row = 0; row < grid.length; row++) {
            for (col = 0; col < grid[0].length; col++) {
                grid[row][col] = ' ';
            }
        }
    }

    /**
     * Checks the winner of the game with either a vertical, horizontal, or diagonal check
     *
     * @param grid   the grid
     * @param player the player
     * @return boolean if any one of the four winning
     * positions are met
     */
    public boolean checkWinner(char[][] grid, char player) {
        return checkDiagonalDown(grid, player) ||
                checkDiagonalUp(grid, player) ||
                checkHorizontal(grid, player) ||
                checkVertical(grid, player);
    }

    /**
     * Checks if the game is a tie.
     *
     * @param grid the game grid
     * @return true if the game is a tie, false otherwise
     */
    public boolean checkTie(char[][] grid) {
        // Check if any of the top cells are empty
        for (int col = 0; col < grid[0].length; col++) {
            if (grid[0][col] == SPACE) {
                return false; // There is at least one empty spot to fill
            }
        }
        // No empty spots at the top; check for a winner
        return true; // no possible slots lef tto fill so we return true
    }

    /**
     * Checks if a player has four consecutive pieces
     * in a horizontal orientation.
     *
     * @param grid   the grid
     * @param player the player
     * @return the boolean
     */
    public boolean checkHorizontal(char[][] grid, char player) {
        for (row = 0; row < grid.length; row++) {
            for (col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col] == player && grid[row][col + 1] == player
                        && grid[row][col + 2] == player
                        && grid[row][col + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if a player has four consecutive pieces
     * in a vertical orientation.
     *
     * @param grid   the grid
     * @param player the player
     * @return the boolean
     */
    public boolean checkVertical(char[][] grid, char player) {
        for (row = 0; row < grid.length - 3; row++) {
            for (col = 0; col < grid[0].length; col++) {
                // check vertical bottom to top
                if (grid[row][col] == player && grid[row + 1][col] == player
                        && grid[row + 2][col] == player
                        && grid[row + 3][col] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if a player has four consecutive pieces
     * in a downward diagonal orientation.
     *
     * @param grid   the grid
     * @param player the player
     * @return the boolean
     */
    public boolean checkDiagonalDown(char[][] grid, char player) {
        for (row = 0; row < grid.length - 3; row++) {
            for (col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col] == player && grid[row + 1][col + 1] == player
                        && grid[row + 2][col + 2] == player
                        && grid[row + 3][col + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if a player has four consecutive pieces
     * in an upward diagonal orientation.

     * @param grid   the grid
     * @param player the player
     * @return the boolean
     */
    public boolean checkDiagonalUp(char[][] grid, char player) {
        try {
            for (row = 0; row < grid.length; row++) {
                for (col = 0; col < grid[0].length - 3; col++) {
                    if (grid[row][col] == player && grid[row - 1][col + 1] == player
                            && grid[row - 2][col + 2] == player
                            && grid[row - 3][col + 3] == player) {
                        return true;
                    }
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
        return false;
    }

    /**
     * Validate move boolean.
     *
     * @param grid   the grid
     * @param number the number
     * @return the boolean
     */
    public static boolean validateMove(char[][] grid, int number) {
        Scanner scanner = new Scanner(System.in);
        while (grid[0][number - 1] != SPACE) {
            System.out.println("All columns filled. Please choose another column");

            // error checking if user enters an integer
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a number only!");
                scanner.next();


            }
            number = scanner.nextInt();
            checkNumberValue(number);
        }
        return true;
    }
}
