package com.example.tictacktoe;

import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**Containing methods that control what happens when a button is clicked*/
public class GameController {

    // controller contains buttons, the buttons are linked to the fxml file, the functionality of the buttons are kept in the model class
    public Button button1;
    public Button button2;
    public Button button3;


    GameModel model = new GameModel();

    public GameModel getModel(){
        return model;
    }

    /**binding the StringProperty in the model class to the button in this class, the button in this class is in turn binded to the fxml file*/
    public void initialize() {
        model.button1PropertyProperty().bindBidirectional(button1.textProperty());
        model.button2PropertyProperty().bindBidirectional(button2.textProperty());
        model.button3PropertyProperty().bindBidirectional(button3.textProperty());
    }


    // todo determine if playerOne or playerTwo gets to click the button
    public void Button1Clicked(MouseEvent mouseEvent) {
        if (getModel().playerOnesTurn){
            setButtonTextToO(getModel().button1PropertyProperty());
            getModel().setPlayerTwosTurn();
        }else{
            setButtonTextToX(getModel().button1PropertyProperty());
            getModel().setPlayerOnesTurn();
        }
    }

    public void Button2Clicked(MouseEvent mouseEvent) {
        setButtonTextToO(getModel().button2PropertyProperty());
    }

    public void Button3Clicked(MouseEvent mouseEvent) {
    }

    public void Button4Clicked(MouseEvent mouseEvent) {
    }

    public void Button5Clicked(MouseEvent mouseEvent) {
    }

    public void Button6Clicked(MouseEvent mouseEvent) {
    }

    public void Button7Clicked(MouseEvent mouseEvent) {
    }

    public void Button8Clicked(MouseEvent mouseEvent) {
    }

    public void Button9Clicked(MouseEvent mouseEvent) {
    }

    /**method that changes text of the button, reusable for all the buttons*/
    public void setButtonTextToX(StringProperty buttonProperty) {
        buttonProperty.set("X");
    }
    public void setButtonTextToO(StringProperty buttonProperty) {
        buttonProperty.set("O");
    }
    public void changeButtonText(StringProperty buttonProperty, String player) {
        buttonProperty.set(player);
    }
}
