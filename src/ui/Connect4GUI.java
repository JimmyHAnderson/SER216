/** Connect4GUI Implmentation in Java
 *
 * @author Jimmy Anderson
 *
 * @version 1 Build 1 Nov 12, 2024.
 */
package ui;

import core.Connect4Client;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;


/**
 * Connect4 GUI Implementation
 *
 */
public class Connect4GUI extends Application {

    private static final int Rows = 6;
    private static final int Cols = 7;
    private static final int stage_Width = 975;
    private static final int stage_Height = 550;
    private Cell[][] cell = new Cell[Rows][Cols];
    private char Turn = '1';
    private Label lblStatus = new Label("Player " + Turn + "'s turn to play");
    private boolean playComputer;
    private boolean computersTurn;


    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Connect4");

        GridPane pane = new GridPane();
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                pane.add(cell[i][j] = new Cell(), j, i);
            }
        }


        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        HBox hbox = addHBox();
        borderPane.setRight(addVBox(lblStatus));
        borderPane.setBottom(hbox);


        Scene scene = new Scene(borderPane, stage_Width, stage_Height + 50);
        stage.setTitle("Connect4"); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show(); // Display the stage


    }

    /**
     * Random number generator for a range of
     * 0 - 6.
     *
     * @param min the minimum range
     * @param max the maximum range
     * @return the int of the random number
     */
    public int randInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }


    /**
     * Computer's move. Will randomly select
     * a move for the computer
     */
    public void computerMove(){
        int random = randInt(0, 6);
        computersTurn = false;
        // Display whose turn
        lblStatus.setText("You are playing \nagainst the computer!");
        for (int i = Rows; i > 0; i--) {
            if (cell[i - 1][random].getToken() == ' ') {
                cell[i - 1][random].handleMouseClick();
                break;
            }
        }
    }

    /**
     * Drops Chip when this is clicked
     */
    class ButtonOne implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            try {
                for (int i = Rows; i > 0; i--) {
                    if (cell[i - 1][0].getToken() == ' ') {
                        cell[i - 1][0].handleMouseClick();
                        if(playComputer){
                            computersTurn = true;
                        }
                        break;
                    }
                }
            } catch (Exception ex) {
                System.out.println("button 1 error" + ex.getMessage());
            }
        }
    }

    /**
     * Drops Chip when this is clicked
     */
    class ButtonTwo implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            try {
                for (int i = Rows; i > 0; i--) {
                    if (cell[i - 1][1].getToken() == ' ') {
                        cell[i - 1][1].handleMouseClick();
                        break;
                    }
                }

            } catch (Exception ex) {
                System.out.println("button 2 error!");
            }
        }
    }

    /**
     * Drops Chip when this is clicked
     */
    class ButtonThree implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            try {
                for (int i = Rows; i > 0; i--) {
                    if (cell[i - 1][2].getToken() == ' ') {
                        cell[i - 1][2].handleMouseClick();
                        break;
                    }
                }

            } catch (Exception ex) {
                System.out.println("button 3 error!");
            }
        }
    }

    /**
     * Drops Chip when this is clicked
     */
    class ButtonFour implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            try {
                for (int i = Rows; i > 0; i--) {
                    if (cell[i - 1][3].getToken() == ' ') {
                        cell[i - 1][3].handleMouseClick();
                        break;
                    }
                }

            } catch (Exception ex) {
                System.out.println("button 4 error!");
            }
        }
    }

    /**
     * Drops Chip when this is clicked
     */
    class ButtonFive implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            try {
                for (int i = Rows; i >= 0; i--) {
                    if (cell[i - 1][4].getToken() == ' ') {
                        cell[i - 1][4].handleMouseClick();
                        break;
                    }
                }

            } catch (Exception ex) {
                System.out.println("button 5 error!");
            }
        }
    }

    /**
     * Drops Chip when this is clicked
     */
    class ButtonSix implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            try {
                for (int i = Rows; i >= 0; i--) {
                    if (cell[i - 1][5].getToken() == ' ') {
                        cell[i - 1][5].handleMouseClick();
                        break;
                    }
                }

            } catch (Exception ex) {
                System.out.println("button 6 error!");
            }
        }
    }

    /**
     * Drops Chip when this is clicked
     */
    class ButtonSeven implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            try {
                for (int i = Rows; i > 0; i--) {
                    if (cell[i - 1][6].getToken() == ' ') {
                        cell[i - 1][6].handleMouseClick();
                        break;
                    }
                }

            } catch (Exception ex) {
                System.out.println("button 7 error! " + ex.getMessage());
            }
        }
    }

    /**
     * Drops Chip when this is clicked
     */
    class ComputerButton implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            playComputer = true;
            computersTurn = false;
            lblStatus.setText("You are playing against the \ncomputer! \nPlayer 1, please start!");
        }
    }

    /**
     * Drops Chip when this is clicked
     */
    class PersonButton implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            playComputer = false;
            computersTurn = false;
            lblStatus.setText("You are playing against another \nperson! \nPlayer 1, please start!");
        }
    }

    /**
     * The type Cell.
     */
        // An inner class for a cell
    public class Cell extends Pane {
        // Token used for this cell
        private char token = ' ';

        /**
         * Instantiates a new Cell.
         */
        public Cell() {
            setStyle("-fx-border-color: black");
            this.setPrefSize(stage_Width, stage_Height);

        }

        /**
         * Return token
         *
         * @return the token
         */
        public char getToken() {
            return token;
        }

        /**
         * Set a new token
         *
         * @param c the c
         */
        public void setToken(char c) {
            token = c;
            Ellipse ellipse = new Ellipse(this.getWidth() / 2,
                    this.getHeight() / 2, this.getWidth() / 2 - 10,
                    this.getHeight() / 2 - 10);
            ellipse.centerXProperty().bind(this.widthProperty().divide(2));
            ellipse.centerYProperty().bind(this.heightProperty().divide(2));
            ellipse.radiusXProperty().bind(this.widthProperty().divide(2).subtract(10));
            ellipse.radiusYProperty().bind(this.heightProperty().divide(2).subtract(10));
            ellipse.setStroke(Color.BLACK);

            if (token == '1') {

                ellipse.setFill(Color.YELLOW);
                getChildren().add(ellipse); // Add the ellipse to the pane
            } else if (token == '2') {


                ellipse.setFill(Color.RED);
                getChildren().add(ellipse); // Add the ellipse to the pane
            }
        }

        /* Handle a mouse click event */
        private void handleMouseClick() {
            // If cell is empty and game doesn't end
            if (token == ' ' && Turn != ' ') {
                setToken(Turn); // Set token in the cell

                // Check game status
                if (isWon(Turn)) {
                    lblStatus.setText("Player " + Turn + " won! \nThe game is over!");
                    Turn = ' '; // Game is over
                } else if (isFull()) {
                    lblStatus.setText("Draw! The game is over");
                    Turn = ' '; // Game is over
                } else {
                    if (!playComputer){
                        // Change the turn
                        Turn = (Turn == '1') ? '2' : '1';
                        // Display whose turn
                        System.out.println(Turn);
                        lblStatus.setText("Player " + Turn + "'s turn to play");
                    }else if(playComputer){
                        // Change the turn
                        Turn = (Turn == '1') ? '2' : '1';
                        if(Turn == '2'){
                            computersTurn = true;
                            computerMove();
                        }
                    }
                }
            }
        }
    }

    /**
     * Is full boolean. Checks to see if grid is full.
     *
     * @return the boolean
     */
    public boolean isFull() {
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols; j++) {
                if (cell[i][j].getToken() == ' ') {
                    return false;
                }
            }
        }
        System.out.println("true");
        return true;
    }


    /**
     * Checks to see who won
     * vertical, horizontal, and diagonal checks
     *
     * @param token the token
     * @return the boolean
     */
    public boolean isWon(char token) {
        int counter = 0;
        // check horizontal win
        for (int i = 0; i < Rows; i++) {
            for (int j = 0; j < Cols - 3; j++) {
                if (cell[i][j].getToken() == token &&
                        cell[i][j + 1].getToken() == token &&
                        cell[i][j + 2].getToken() == token &&
                        cell[i][j + 3].getToken() == token) {
                    System.out.println("horizontal true");
                    return true;
                }
            }
        }

        // check vertical
        for (int i = 0; i < Rows - 3; i++) {
            for (int j = 0; j < Cols; j++) {
                if (cell[i][j].getToken() == token &&
                        cell[i + 1][j].getToken() == token &&
                        cell[i + 2][j].getToken() == token &&
                        cell[i + 3][j].getToken() == token) {
                    System.out.println("vertical true");
                    return true;
                }
            }
        }

        // Down-right diagonal
        for (int i = 0; i < Rows - 3; i++) {
            for (int j = 0; j < Cols - 3; j++) {
                if (cell[i][j].getToken() == token &&
                        cell[i + 1][j + 1].getToken() == token &&
                        cell[i + 2][j + 2].getToken() == token &&
                        cell[i + 3][j + 3].getToken() == token) {
                    return true;
                }
            }
        }
// Up-right diagonal
        for (int i = 3; i < Rows; i++) {
            for (int j = 0; j < Cols - 3; j++) {
                if (cell[i][j].getToken() == token &&
                        cell[i - 1][j + 1].getToken() == token &&
                        cell[i - 2][j + 2].getToken() == token &&
                        cell[i - 3][j + 3].getToken() == token) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Adds horizontal box to the GUI.
     *
     * @return the HBox
     */
    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #B22222;");

        Button number1 = new Button("#1");
        number1.setPrefSize(100, 20);
        number1.setOnAction(new ButtonOne());

        Button number2 = new Button("#2");
        number2.setPrefSize(100, 20);
        number2.setOnAction(new ButtonTwo());

        Button number3 = new Button("#3");
        number3.setPrefSize(100, 20);
        number3.setOnAction(new ButtonThree());

        Button number4 = new Button("#4");
        number4.setPrefSize(100, 20);
        number4.setOnAction(new ButtonFour());

        Button number5 = new Button("#5");
        number5.setPrefSize(100, 20);
        number5.setOnAction(new ButtonFive());

        Button number6 = new Button("#6");
        number6.setPrefSize(100, 20);
        number6.setOnAction(new ButtonSix());

        Button number7 = new Button("#7");
        number7.setPrefSize(100, 20);
        number7.setOnAction(new ButtonSeven());


        hbox.getChildren().addAll(number1, number2, number3, number4, number5, number6, number7);



        return hbox;
    }

    /**
     * Adds vertical box to the GUI.
     *
     * @param lblStatus the lbl status
     * @return the VBox
     */
    public VBox addVBox(Label lblStatus) {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(20));
        vbox.setSpacing(8);

        Text whichPlayer = new Text("Select to play the computer \nor another person!");
        whichPlayer.setFont(Font.font("Arial", FontWeight.LIGHT, 14));

        Button computer = new Button("Computer");
        Button person = new Button("Person");
        vbox.getChildren().addAll(whichPlayer, computer, person);

        computer.setOnAction(new ComputerButton());
        person.setOnAction(new PersonButton());


        Text titleText = new Text("Moves:");
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        lblStatus.setFont(Font.font("Arial", FontWeight.LIGHT, 14));
        VBox.setMargin(titleText, new Insets(10, 0, 10, 10));
        vbox.getChildren().addAll(titleText, lblStatus);
        return vbox;
    }

    /**
     * main method that launches the application
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}