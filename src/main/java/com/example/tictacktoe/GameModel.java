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
    public List<Integer> playerPositionList = new ArrayList<>();
    public List<Integer> computerPositionList = new ArrayList<>();

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

    private void resetButtonText() {
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

    public String getWinner() {
        return winner;
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
        System.out.println(playerPositionList.size());
        System.out.println(computerPositionList.size());
        winner = "Nobody won"; // used for unit test
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
    private final Button button1 = new Button("button1");
    private final StringProperty button1Property = button1.textProperty();

    private final Button button2 = new Button("button2");
    private final StringProperty button2Property = button2.textProperty();

    private final Button button3 = new Button("button3");
    private final StringProperty button3Property = button3.textProperty();

    private final Button button4 = new Button("button4");
    private final StringProperty button4Property = button4.textProperty();

    private final Button button5 = new Button("button5");
    private final StringProperty button5Property = button5.textProperty();

    private final Button button6 = new Button("button6");
    private final StringProperty button6Property = button6.textProperty();

    private final Button button7 = new Button("button7");
    private final StringProperty button7Property = button7.textProperty();

    private final Button button8 = new Button("button8");
    private final StringProperty button8Property = button8.textProperty();

    private final Button button9 = new Button("button9");
    private final StringProperty button9Property = button9.textProperty();

    private final Button exitProgramButton = new Button("exit program");
    private final StringProperty exitProgramButtonProperty = exitProgramButton.textProperty();

    private final Button playAgainButton = new Button("play again");
    private final StringProperty playAgainButtonProperty = playAgainButton.textProperty();


    public StringProperty exitProgramButtonPropertyProperty() {
        return exitProgramButtonProperty;
    }


    public StringProperty playAgainButtonPropertyProperty() {
        return playAgainButtonProperty;
    }


    public StringProperty button1PropertyProperty() {
        return button1Property;
    }


    public StringProperty button2PropertyProperty() {
        return button2Property;
    }


    public StringProperty button3PropertyProperty() {
        return button3Property;
    }


    public StringProperty button4PropertyProperty() {
        return button4Property;
    }


    public StringProperty button5PropertyProperty() {
        return button5Property;
    }


    public StringProperty button6PropertyProperty() {
        return button6Property;
    }


    public StringProperty button7PropertyProperty() {
        return button7Property;
    }


    public StringProperty button8PropertyProperty() {
        return button8Property;
    }


    public StringProperty button9PropertyProperty() {
        return button9Property;
    }


    public String getWinnerMessage() {
        return winnerMessage;
    }
}
