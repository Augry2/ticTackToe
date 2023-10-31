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

    private final GameModel model = new GameModel();

    public GameModel getModel() {
        return model;
    }


    /**
     * binding the StringProperty in the model class to the button in this class, the button in this class is in turn bound to the fxml file
     */
    public void initialize() {
        button1.textProperty().bindBidirectional(model.button1PropertyProperty());
        button2.textProperty().bindBidirectional(model.button2PropertyProperty());
        button3.textProperty().bindBidirectional(model.button3PropertyProperty());
        button4.textProperty().bindBidirectional(model.button4PropertyProperty());
        button5.textProperty().bindBidirectional(model.button5PropertyProperty());
        button6.textProperty().bindBidirectional(model.button6PropertyProperty());
        button7.textProperty().bindBidirectional(model.button7PropertyProperty());
        button8.textProperty().bindBidirectional(model.button8PropertyProperty());
        button9.textProperty().bindBidirectional(model.button9PropertyProperty());
        playAgainButton.textProperty().bindBidirectional(model.playAgainButtonPropertyProperty());
        exitProgramButton.textProperty().bindBidirectional(model.exitProgramButtonPropertyProperty());
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

    public void resetGame() {
        model.resetModelData();
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
        model.buttonClick(1);
    }

    public void Button2Clicked() {
        model.buttonClick(2);
    }

    public void Button3Clicked() {
        model.buttonClick(3);
    }

    public void Button4Clicked() {
        model.buttonClick(4);
    }

    public void Button5Clicked() {
        model.buttonClick(5);
    }

    public void Button6Clicked() {
        model.buttonClick(6);
    }

    public void Button7Clicked() {
        model.buttonClick(7);
    }

    public void Button8Clicked() {
        model.buttonClick(8);
    }

    public void Button9Clicked() {
        model.buttonClick(9);
    }
}