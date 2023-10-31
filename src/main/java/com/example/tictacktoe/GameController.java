package com.example.tictacktoe;

import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Containing methods that control what happens when a button is clicked
 */
public class GameController {


    // controller contains buttons, the buttons are linked to the fxml file, the functionality of the buttons are kept in the model class
    public Button button1 = new Button();
    public Button button2 = new Button();
    public Button button3 = new Button();
    public Button button4 = new Button();
    public Button button5 = new Button();
    public Button button6 = new Button();
    public Button button7 = new Button();
    public Button button8 = new Button();
    public Button button9 = new Button();
    public Label winnerAnounce = new Label(); // should be visible when a winner is decided
    public Button playAgainButton = new Button();
    public Button exitProgramButton = new Button();

    boolean[] buttonsClicked = new boolean[9]; // remembers which buttons has been clicked

    private final GameModel model = new GameModel();

    public GameModel getModel() {
        return model;
    }


    /**
     * binding the StringProperty in the model class to the button in this class, the button in this class is in turn bound to the fxml file
     */
    public void initialize() {
        button1.textProperty().bind(model.button1PropertyProperty());
        button2.textProperty().bind(model.button2PropertyProperty());
        button3.textProperty().bind(model.button3PropertyProperty());
        button4.textProperty().bind(model.button4PropertyProperty());
        button5.textProperty().bind(model.button5PropertyProperty());
        button6.textProperty().bind(model.button6PropertyProperty());
        button7.textProperty().bind(model.button7PropertyProperty());
        button8.textProperty().bind(model.button8PropertyProperty());
        button9.textProperty().bind(model.button9PropertyProperty());
        playAgainButton.textProperty().bind(model.playAgainButtonPropertyProperty());
        exitProgramButton.textProperty().bind(model.exitProgramButtonPropertyProperty());
    }

    /**
     * decides which button the computer will click
     */
    public void handleComputerClick() {

        Random random = new Random();
        int computerMove = random.nextInt(9) + 1;
        boolean invalidComputerMove = true;

        // keep generating numbers until an available button is found then puts it on the board
        while (invalidComputerMove) {
            if (!buttonsClicked[computerMove - 1]) {
                handleButtonClick(getButtonByNumber(computerMove), computerMove, buttonsClicked,
                        getModel().getPlayerPositionList(), getModel().getComputerPositionList());
                invalidComputerMove = false;
            } else {
                computerMove = random.nextInt(9) + 1;
            }
        }
    }

    public boolean[] getButtonsClicked() {
        return buttonsClicked;
    }


    /**
     * used by the handleComputerClick method to return a Button based on what number is input as parameter
     */
    public Button getButtonByNumber(int buttonNr) {
        return switch (buttonNr) {
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
     * the program uses a list of booleans to check which buttons has been clicked, this method checks if
     * there are any available buttons to click
     */
    private boolean areAllButtonsClicked(boolean[] buttonClickedArray) {
        for (boolean buttonClicked : buttonClickedArray) {
            if (!buttonClicked) {
                return false; // If any button is not clicked, return false
            }
        }
        return true; // All buttons are clicked, return true
    }


    /**
     * functionality for what happens when the user or the computer clicks a button
     */
    public void handleButtonClick(Button button, int buttonNumber, boolean[] buttonClickedArray, List<Integer> playerPositionList, List<Integer> computerPositionList) {

        if (!buttonClickedArray[buttonNumber - 1]) { // (run if the button is free) need to set this to -1 because the buttons start at 1 - 10, and the boolean array starts at 0 - 9
            if (getModel().playerOnesTurn) {
                model.button1PropertyProperty().set("O");
                //button.setText("O");
                getModel().setPlayerTwosTurn();
                playerPositionList.add(buttonNumber); // adds the position of the button into the list in the model

            } else {
                model.button1PropertyProperty().set("X");
                getModel().setPlayerOnesTurn();
                computerPositionList.add(buttonNumber);


            }
            buttonClickedArray[buttonNumber - 1] = true; // need to set this to -1 because the buttons start at 1 - 10, and the boolean array starts at 0 - 9


            // after the player has taken a turn, it checks if he or computer won, if nobody won the computer gets its turn
            if (getModel().checkEndRound()) { // runs checkWin aswell as the if statement
                winnerAnounce.textProperty().set(model.getWinnerMessage());
                disableButtons();
            } else if (getModel().playerTwosTurn) {
                handleComputerClick();
            }
        }
    }

    public void enableButtons() {
        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
        button5.setDisable(false);
        button6.setDisable(false);
        button7.setDisable(false);
        button8.setDisable(false);
        button9.setDisable(false);
    }

    public void disableButtons() {
        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        button4.setDisable(true);
        button5.setDisable(true);
        button6.setDisable(true);
        button7.setDisable(true);
        button8.setDisable(true);
        button9.setDisable(true);
    }

    public void resetGame() {
        model.resetModelData();
        Arrays.fill(buttonsClicked, false);
        winnerAnounce.setText("");
        enableButtons();

    }

    public void PlayAgainButtonClicked() {
        resetGame();
    }

    public void ExitProgramButtonClicked() {
        Platform.exit();
    }

    public void Button1Clicked() {
        handleButtonClick(button1, 1, buttonsClicked, getModel().getPlayerPositionList(), getModel().getComputerPositionList());
    }

    public void Button2Clicked() {
        handleButtonClick(button2, 2, buttonsClicked, getModel().getPlayerPositionList(), getModel().getComputerPositionList());
    }

    public void Button3Clicked() {
        handleButtonClick(button3, 3, buttonsClicked, getModel().getPlayerPositionList(), getModel().getComputerPositionList());
    }

    public void Button4Clicked() {
        handleButtonClick(button4, 4, buttonsClicked, getModel().getPlayerPositionList(), getModel().getComputerPositionList());
    }

    public void Button5Clicked() {
        handleButtonClick(button5, 5, buttonsClicked, getModel().getPlayerPositionList(), getModel().getComputerPositionList());
    }

    public void Button6Clicked() {
        handleButtonClick(button6, 6, buttonsClicked, getModel().getPlayerPositionList(), getModel().getComputerPositionList());
    }

    public void Button7Clicked() {
        handleButtonClick(button7, 7, buttonsClicked, getModel().getPlayerPositionList(), getModel().getComputerPositionList());
    }

    public void Button8Clicked() {
        handleButtonClick(button8, 8, buttonsClicked, getModel().getPlayerPositionList(), getModel().getComputerPositionList());
    }

    public void Button9Clicked() {
        handleButtonClick(button9, 9, buttonsClicked, getModel().getPlayerPositionList(), getModel().getComputerPositionList());
    }

    public void setButtonTextToX(StringProperty buttonProperty) {
        buttonProperty.set("X");
    }

    public void setButtonTextToO(StringProperty buttonProperty) {
        buttonProperty.set("O");
    }


}
