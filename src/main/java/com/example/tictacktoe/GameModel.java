package com.example.tictacktoe;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.*;

/**
 * contains the data and logic behind the game
 */
public class GameModel {

    private boolean playerOnesTurn = true; // if a player is true, then it can make a move, if false it cannot, when a move is made it should be set to false,
    private boolean playerTwosTurn = false;                                                                            // the other one should be set to true

    private int playerWins; // contains total amount of wins
    private int computerWins;
    private boolean playerWonTheRound = false;


    //when player presses a button the controller class will add an integer into this list for respective buttons clicked, if nr1 is pressed int 1 is added to this list
    private final List<Integer> playerPositionList = new ArrayList<>();
    private final List<Integer> computerPositionList = new ArrayList<>();

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
        playerWonTheRound = false;

        // Reset button properties
        resetButtonText();
    }

    private void resetButtonText() {
        button1.set("");
        button2.set("");
        button3.set("");
        button4.set("");
        button5.set("");
        button6.set("");
        button7.set("");
        button8.set("");
        button9.set("");
    }

    /**
     * controls what happens when the user clicks one of the buttons. after a button
     * has been clicked the computer will automatically click another button
     */
    public void placeMark(int i) {

        if (playerOnesTurn) {
            if (buttonIsValid(i)) {
                switch (i) {
                    case 1, 2, 3, 4, 5, 6, 7, 8, 9:
                        placePlayerMark(i);
                        break;
                }
            }

            if (playerTwosTurn && !playerWonTheRound) {
                if (playerPositionList.size() + computerPositionList.size() == 9)
                    return;
                placeComputerMark();
            }
        }
    }

    private void placeComputerMark() {
        randomButtonClick();
        setPlayerOnesTurn();
        checkEndRound();
    }

    private void placePlayerMark(int i) {
        StringProperty button = getButtonPropertyByNumber(i);

        button.set("O");
        playerPositionList.add(i);
        setPlayerTwosTurn();
        checkEndRound();

    }

    /**
     * clicks a random button that has not already been selected
     */
    private void randomButtonClick() {
        Random random = new Random();
        int randomNumber;
        StringProperty randomButtonProperty;

        do {
            randomNumber = random.nextInt(9) + 1;
            randomButtonProperty = getButtonPropertyByNumber(randomNumber);
        } while (!buttonIsValid(randomNumber));

        randomButtonProperty.set("X");
        computerPositionList.add(randomNumber);
    }

    /**
     * checks if a button is already clicked
     */
    private boolean buttonIsValid(int number) {
        return !playerPositionList.contains(number) && !computerPositionList.contains(number);
    }

    /**
     * returns a StringProperty based on which number is sent in, 1 resembles StringProperty for button1
     */
    private StringProperty getButtonPropertyByNumber(int randomNumber) {
        return switch (randomNumber) {
            case 1 -> button1;
            case 2 -> button2;
            case 3 -> button3;
            case 4 -> button4;
            case 5 -> button5;
            case 6 -> button6;
            case 7 -> button7;
            case 8 -> button8;
            case 9 -> button9;
            default -> null;
        };
    }


    /**
     * method that checks if the use or computer has put 3 marks in a row then returns true or false depending on the result
     */
    public boolean checkEndRound() {
        List<List<Integer>> winCons = getLists(); // creates a list containing all the different win-conditions

        for (List<Integer> current : winCons) {
            if (new HashSet<>(playerPositionList).containsAll(current)) {
                playerWins++;
                playerWonTheRound = true;
                winnerAnnounce.set("Player Won" + "\n" + "Player: " + playerWins + "\n" + "Computer: " + computerWins);
                return true;
            }
        }
        for (List<Integer> current : winCons) {
            if (new HashSet<>(computerPositionList).containsAll(current)) {
                computerWins++;
                winnerAnnounce.set("Computer Won" + "\n" + "Player: " + playerWins + "\n" + "Computer: " + computerWins);
                return true;
            }
        }

        int playerPlusComputerCounter = playerPositionList.size() + computerPositionList.size();
        if (playerPlusComputerCounter == 9) {
            winnerAnnounce.set("The game is a tie" + "\n" + "Player: " + playerWins + "\n" + "Computer: " + computerWins);
            return true;
        }

        return false;
    }

    /**
     * returns a list with all the different win conditions for the game
     */
    private static List<List<Integer>> getLists() {
        List<Integer> topRow = Arrays.asList(1, 2, 3);
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> botRow = Arrays.asList(7, 8, 9);
        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);
        List<Integer> cross1 = Arrays.asList(1, 5, 9);
        List<Integer> cross2 = Arrays.asList(3, 5, 7);
        List<List<Integer>> winCons = new ArrayList<>();
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


    private void setPlayerTwosTurn() {
        playerOnesTurn = false;
        playerTwosTurn = true;
    }


    private void setPlayerOnesTurn() {
        playerTwosTurn = false;
        playerOnesTurn = true;
    }


    private final StringProperty button1 = new SimpleStringProperty("");

    private final StringProperty button2 = new SimpleStringProperty("");

    private final StringProperty button3 = new SimpleStringProperty("");

    private final StringProperty button4 = new SimpleStringProperty("");

    private final StringProperty button5 = new SimpleStringProperty("");

    private final StringProperty button6 = new SimpleStringProperty("");

    private final StringProperty button7 = new SimpleStringProperty("");

    private final StringProperty button8 = new SimpleStringProperty("");

    private final StringProperty button9 = new SimpleStringProperty("");

    private final StringProperty winnerAnnounce = new SimpleStringProperty("");


    public StringProperty button1Property() {
        return button1;
    }

    public StringProperty button2Property() {
        return button2;
    }

    public StringProperty button3Property() {
        return button3;
    }

    public StringProperty button4Property() {
        return button4;
    }

    public StringProperty button5Property() {
        return button5;
    }

    public StringProperty button6Property() {
        return button6;
    }

    public StringProperty button7Property() {
        return button7;
    }

    public StringProperty button8Property() {
        return button8;
    }

    public StringProperty button9Property() {
        return button9;
    }

    public StringProperty winnerAnnounceProperty() {
        return winnerAnnounce;
    }
}
