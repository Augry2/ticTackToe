package com.example.tictacktoe;

import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * contains the data and logic behind the game
 */
public class GameModel {

    public boolean playerOnesTurn = true; // if a player is true, then it can make a move, if false it cannot, when a move is made it should be set to false,
    public boolean playerTwosTurn = false;                                                                            // the other one should be set to true
    private String winner; // String containing who won the round
    private int playerWins; // contains total amount of wins
    private int computerWins;
    private String winnerMessage; // String to be printed out after each non-tie round


    public int getPlayerWins() {
        return playerWins;
    }

    public int getComputerWins() {
        return computerWins;
    }


    //when player presses a button the controller class will add an integer into this list for respective buttons clicked, if nr1 is pressed int 1 is added to this list
    private final List<Integer> playerPositionList = new ArrayList<>();
    private final List<Integer> computerPositionList = new ArrayList<>(); // todo not sure why this is final

    public List<Integer> getPlayerPositionList() {
        return playerPositionList;
    }
    public List<Integer> getComputerPositionList() {
        return computerPositionList;
    }

    public void resetModelData() {
        // Clear player and computer position lists
        playerPositionList.clear();
        computerPositionList.clear();

        // Reset turn variables
        playerOnesTurn = true;
        playerTwosTurn = false;

        // Reset winner and winner message
        winner = null;
        winnerMessage = null;

        // Reset button properties
        resetButtonText();
    }

    private void resetButtonText(){
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
    }

    /*method that checks if the use or computer has put 3 marks in a row then returns true or false depending on the result **/
    public boolean checkWin() {
        List<List> winCons = getLists(); // creates a list containing all the diffrent win-conditions

        for (List current : winCons) {
            if (playerPositionList.containsAll(current)) {
                System.out.println("Player Won");
                winner = "Player Won";
                playerWins++;
                winnerMessage = winner + "\n" + "Player: " + playerWins + "\n" + "Computer: " + computerWins;
                return true;
            }
        }
        for (List current : winCons) {
            if (computerPositionList.containsAll(current)) {
                System.out.println("Computer Won");
                winner = "Computer Won";
                computerWins++;
                winnerMessage = winner + "\n" + "Player: " + playerWins + "\n" + "Computer: " + computerWins;
                return true;
            }
        }


        return false;
    }

    /*generes the diffrent win conditions for the checWins method **/
    private static List<List> getLists() {
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);
        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);
        List<Integer> cross1 = Arrays.asList(1, 5, 9);
        List<Integer> cross2 = Arrays.asList(3, 5, 7);
        List<List> winCons = new ArrayList<>();
        winCons.add(topRow);
        winCons.add(midRow);
        winCons.add(botRow);
        winCons.add(leftCol);
        winCons.add(midCol);
        winCons.add(rightCol);
        winCons.add(cross1);
        winCons.add(cross2);

        return winCons;
    }

    /*makes it so the player can pick a box**/
    public void setPlayerTwosTurn() {
        playerOnesTurn = false;
        playerTwosTurn = true;
    }

    /*makes it so the computer will pick a box**/
    public void setPlayerOnesTurn() {
        playerTwosTurn = false;
        playerOnesTurn = true;
    }


    // variables for all the buttons here
    private Button button1 = new Button("button1");
    private final StringProperty button1Property = button1.textProperty();// todo how can these be final

    private Button button2 = new Button("button2");
    private final StringProperty button2Property = button2.textProperty();

    private Button button3 = new Button("button3");
    private final StringProperty button3Property = button3.textProperty();

    private Button button4 = new Button("button4");
    private final StringProperty button4Property = button4.textProperty();

    private Button button5 = new Button("button5");
    private final StringProperty button5Property = button5.textProperty();

    private Button button6 = new Button("button6");
    private final StringProperty button6Property = button6.textProperty();

    private Button button7 = new Button("button7");
    private final StringProperty button7Property = button7.textProperty();

    private Button button8 = new Button("button8");
    private final StringProperty button8Property = button8.textProperty();

    private Button button9 = new Button("button9");
    private final StringProperty button9Property = button9.textProperty();

    private Button exitProgramButton = new Button("exit program");
    private final StringProperty exitProgramButtonProperty = exitProgramButton.textProperty();

    private Button playAgainButton = new Button("play again");
    private final StringProperty playAgainButtonProperty = playAgainButton.textProperty();



    public Button getExitProgramButton() {
        return exitProgramButton;
    }

    public void setExitProgramButton(Button exitProgramButton) {
        this.exitProgramButton = exitProgramButton;
    }

    public String getExitProgramButtonProperty() {
        return exitProgramButtonProperty.get();
    }

    public StringProperty exitProgramButtonPropertyProperty() {
        return exitProgramButtonProperty;
    }

    public void setExitProgramButtonProperty(String exitProgramButtonProperty) {
        this.exitProgramButtonProperty.set(exitProgramButtonProperty);
    }

    public Button getPlayAgainButton() {
        return playAgainButton;
    }

    public void setPlayAgainButton(Button playAgainButton) {
        this.playAgainButton = playAgainButton;
    }

    public String getPlayAgainButtonProperty() {
        return playAgainButtonProperty.get();
    }

    public StringProperty playAgainButtonPropertyProperty() {
        return playAgainButtonProperty;
    }

    public void setPlayAgainButtonProperty(String playAgainButtonProperty) {
        this.playAgainButtonProperty.set(playAgainButtonProperty);
    }

    public Button getButton1() {
        return button1;
    }

    public void setButton1(Button button1) {
        this.button1 = button1;
    }

    public String getButton1Property() {
        return button1Property.get();
    }

    public StringProperty button1PropertyProperty() {
        return button1Property;
    }

    public void setButton1Property(String button1Property) {
        this.button1Property.set(button1Property);
    }

    public Button getButton2() {
        return button2;
    }

    public void setButton2(Button button2) {
        this.button2 = button2;
    }

    public String getButton2Property() {
        return button2Property.get();
    }

    public StringProperty button2PropertyProperty() {
        return button2Property;
    }

    public void setButton2Property(String button2Property) {
        this.button2Property.set(button2Property);
    }

    public Button getButton3() {
        return button3;
    }

    public void setButton3(Button button3) {
        this.button3 = button3;
    }

    public String getButton3Property() {
        return button3Property.get();
    }

    public StringProperty button3PropertyProperty() {
        return button3Property;
    }

    public void setButton3Property(String button3Property) {
        this.button3Property.set(button3Property);
    }

    public Button getButton4() {
        return button4;
    }

    public void setButton4(Button button4) {
        this.button4 = button4;
    }

    public String getButton4Property() {
        return button4Property.get();
    }

    public StringProperty button4PropertyProperty() {
        return button4Property;
    }

    public void setButton4Property(String button4Property) {
        this.button4Property.set(button4Property);
    }

    public Button getButton5() {
        return button5;
    }

    public void setButton5(Button button5) {
        this.button5 = button5;
    }

    public String getButton5Property() {
        return button5Property.get();
    }

    public StringProperty button5PropertyProperty() {
        return button5Property;
    }

    public void setButton5Property(String button5Property) {
        this.button5Property.set(button5Property);
    }

    public Button getButton6() {
        return button6;
    }

    public void setButton6(Button button6) {
        this.button6 = button6;
    }

    public String getButton6Property() {
        return button6Property.get();
    }

    public StringProperty button6PropertyProperty() {
        return button6Property;
    }

    public void setButton6Property(String button6Property) {
        this.button6Property.set(button6Property);
    }

    public Button getButton7() {
        return button7;
    }

    public void setButton7(Button button7) {
        this.button7 = button7;
    }

    public String getButton7Property() {
        return button7Property.get();
    }

    public StringProperty button7PropertyProperty() {
        return button7Property;
    }

    public void setButton7Property(String button7Property) {
        this.button7Property.set(button7Property);
    }

    public Button getButton8() {
        return button8;
    }

    public void setButton8(Button button8) {
        this.button8 = button8;
    }

    public String getButton8Property() {
        return button8Property.get();
    }

    public StringProperty button8PropertyProperty() {
        return button8Property;
    }

    public void setButton8Property(String button8Property) {
        this.button8Property.set(button8Property);
    }

    public Button getButton9() {
        return button9;
    }

    public void setButton9(Button button9) {
        this.button9 = button9;
    }

    public String getButton9Property() {
        return button9Property.get();
    }

    public StringProperty button9PropertyProperty() {
        return button9Property;
    }

    public void setButton9Property(String button9Property) {
        this.button9Property.set(button9Property);
    }

    public String getWinnerMessage() {
        return winnerMessage;
    }
}
