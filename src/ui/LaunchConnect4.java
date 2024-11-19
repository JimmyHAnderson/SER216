/** LaunchConnect4 Implementation in Java
 *
 * @author Jimmy Anderson
 *
 * @version 2 Build 1 Nov 9, 2024.
 */
package ui;

import core.Connect4Client;
import core.Connect4Server;
import javafx.application.Application;

import java.util.Scanner;
/**
 * LaunchConnect4 Implementation
 *
 */
public class LaunchConnect4 {

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter 'G' for JavaFX GUI or 'T' for text UI:");
            char selection = scanner.next().charAt(0);

            if (selection == 'G') {
                Application.launch(Connect4Client.class, args);
            } else if (selection == 'T') {
                // Assuming you have implemented the Connect4TextConsole class
                new Connect4TextConsole().runGame();
            } else {
                System.out.println("Invalid Entry!\n");
            }
        }
    }