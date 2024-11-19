/** Connect4ComputerPlayer Implementation in Java
 *
 * @author Jimmy Anderson
 *
 * @version 1 Build 1 Oct 28, 2024.
 */
package core;
import java.util.Random;



public class Connect4ComputerPlayer extends Connect4Logic{
    /**
     * Instantiates a new Connect 4 computer player.
     */
    public Connect4ComputerPlayer() {

    }

    public static int randomInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }
    /**
     * Computer makes the move.
     *
     * @param grid   the grid
     * @param player the player
     */
    public static void computerMakeMove(char[][] grid, char player) {
        int number = randomInt(1, 7);
        while (grid[0][number - 1] != SPACE) {
            number = randomInt(1, 7);

        }

        for (int row = grid.length - 1; row >= 0; row--) {
            if (grid[row][number - 1] == SPACE) {
                grid[row][number - 1] = player;
                break;
            }
        }
        Connect4Logic.drawGrid(grid);
    }
}
