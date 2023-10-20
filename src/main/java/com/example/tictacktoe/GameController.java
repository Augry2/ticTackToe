package com.example.tictacktoe;

import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

/**Containing methods that control what happens when a button is clicked*/
public class GameController {

    // controller contains buttons, the buttons are linked to the fxml file, the functionality of the buttons are kept in the model class
    public Button button1;
    public Button button2;
    public Button button3;
    public Button button4;
    public Button button5;
    public Button button6;
    public Button button7;
    public Button button8;
    public Button button9;
    private boolean button1Clicked = false;
    private boolean button2Clicked = false;
    private boolean button3Clicked = false;
    private boolean button4Clicked = false;
    private boolean button5Clicked = false;
    private boolean button6Clicked = false;
    private boolean button7Clicked = false;
    private boolean button8Clicked = false;
    private boolean button9Clicked = false;

    GameModel model = new GameModel();
    public GameModel getModel(){
        return model;
    }

    /**binding the StringProperty in the model class to the button in this class, the button in this class is in turn bound to the fxml file*/
    public void initialize() {
        model.button1PropertyProperty().bindBidirectional(button1.textProperty());
        model.button2PropertyProperty().bindBidirectional(button2.textProperty());
        model.button3PropertyProperty().bindBidirectional(button3.textProperty());
        model.button4PropertyProperty().bindBidirectional(button4.textProperty());
        model.button5PropertyProperty().bindBidirectional(button5.textProperty());
        model.button6PropertyProperty().bindBidirectional(button6.textProperty());
        model.button7PropertyProperty().bindBidirectional(button7.textProperty());
        model.button8PropertyProperty().bindBidirectional(button8.textProperty());
        model.button9PropertyProperty().bindBidirectional(button9.textProperty());
    }
    //boolean[] buttonClickedArray = {false,false,false,false,false,false,false,false,false};
    boolean[] buttonClickedArray = new boolean[9];
    public void handleButtonClick(Button button, int buttonNumber, boolean[] buttonClickedArray, List<Integer> playerPositionList, List<Integer> computerPositionList) {

        if (!buttonClickedArray[buttonNumber-1]) { // need to set this to -1 because the buttons start at 1 - 10, and the boolean array starts at 0 - 9
            if (getModel().playerOnesTurn) {
                setButtonTextToO(button.textProperty());
                getModel().setPlayerTwosTurn();
                playerPositionList.add(buttonNumber); // adds the position of the button into the list in the model
            } else {
                setButtonTextToX(button.textProperty());
                getModel().setPlayerOnesTurn();
                computerPositionList.add(buttonNumber);
            }
            buttonClickedArray[buttonNumber-1] = true; // need to set this to -1 because the buttons start at 1 - 10, and the boolean array starts at 0 - 9
            getModel().checkWin();
        }
    }

    // todo this works, but find a way to put the code inside a generic method so we dont have to copy paste the same code for every method
    public void Button1Clicked(MouseEvent mouseEvent) {

        handleButtonClick(button1, 1, buttonClickedArray, getModel().getPlayerPositionList(), getModel().getComputerPositionList());


//       if (!button1Clicked){
//           if (getModel().playerOnesTurn){
//               setButtonTextToO(getModel().button1PropertyProperty());
//               getModel().setPlayerTwosTurn();
//               getModel().getPlayerPositionList().add(1); // adds the position of the first button into a list in the model (gona be used for determine winner)
//           }else{
//               setButtonTextToX(getModel().button1PropertyProperty());
//               getModel().setPlayerOnesTurn();
//               getModel().getComputerPositionList().add(1);
//           }
//           button1Clicked = true;
//           getModel().checkWin();
//       }


    }

    public void Button2Clicked(MouseEvent mouseEvent) {
        handleButtonClick(button2, 2, buttonClickedArray, getModel().getPlayerPositionList(), getModel().getComputerPositionList());
//        if (!button2Clicked){
//            if (getModel().playerOnesTurn){
//                setButtonTextToO(getModel().button2PropertyProperty());
//                getModel().setPlayerTwosTurn();
//                getModel().getPlayerPositionList().add(2);
//            }else{
//                setButtonTextToX(getModel().button2PropertyProperty());
//                getModel().setPlayerOnesTurn();
//                getModel().getComputerPositionList().add(2);
//            }
//            button2Clicked = true;
//            getModel().checkWin();
//
//        }
    }

    public void Button3Clicked(MouseEvent mouseEvent) {
        handleButtonClick(button3, 3, buttonClickedArray, getModel().getPlayerPositionList(), getModel().getComputerPositionList());
//        if (!button3Clicked){
//            if (getModel().playerOnesTurn){
//                setButtonTextToO(getModel().button3PropertyProperty());
//                getModel().setPlayerTwosTurn();
//                getModel().getPlayerPositionList().add(3);
//            }else{
//                setButtonTextToX(getModel().button3PropertyProperty());
//                getModel().setPlayerOnesTurn();
//                getModel().getComputerPositionList().add(3);
//            }
//            button3Clicked = true;
//            getModel().checkWin();
//        }
    }

    public void Button4Clicked(MouseEvent mouseEvent) {
        handleButtonClick(button4, 4, buttonClickedArray, getModel().getPlayerPositionList(), getModel().getComputerPositionList());
//        if (!button4Clicked) {
//            if (getModel().playerOnesTurn) {
//                setButtonTextToO(getModel().button4PropertyProperty());
//                getModel().setPlayerTwosTurn();
//                getModel().getPlayerPositionList().add(4);
//            } else {
//                setButtonTextToX(getModel().button4PropertyProperty());
//                getModel().setPlayerOnesTurn();
//                getModel().getComputerPositionList().add(4);
//            }
//            button4Clicked = true;
//            getModel().checkWin();
//        }
    }

    public void Button5Clicked(MouseEvent mouseEvent) {
        handleButtonClick(button5, 5, buttonClickedArray, getModel().getPlayerPositionList(), getModel().getComputerPositionList());
//        if (!button5Clicked) {
//            if (getModel().playerOnesTurn) {
//                setButtonTextToO(getModel().button5PropertyProperty());
//                getModel().setPlayerTwosTurn();
//                getModel().getPlayerPositionList().add(5);
//            } else {
//                setButtonTextToX(getModel().button5PropertyProperty());
//                getModel().setPlayerOnesTurn();
//                getModel().getComputerPositionList().add(5);
//            }
//            button5Clicked = true;
//            getModel().checkWin();
//        }
    }

    public void Button6Clicked(MouseEvent mouseEvent) {
        handleButtonClick(button6, 6, buttonClickedArray, getModel().getPlayerPositionList(), getModel().getComputerPositionList());
//        if (!button6Clicked) {
//            if (getModel().playerOnesTurn) {
//                setButtonTextToO(getModel().button6PropertyProperty());
//                getModel().setPlayerTwosTurn();
//                getModel().getPlayerPositionList().add(6);
//            } else {
//                setButtonTextToX(getModel().button6PropertyProperty());
//                getModel().setPlayerOnesTurn();
//                getModel().getComputerPositionList().add(6);
//            }
//            button6Clicked = true;
//            getModel().checkWin();
//        }
    }

    public void Button7Clicked(MouseEvent mouseEvent) {
        handleButtonClick(button7, 7, buttonClickedArray, getModel().getPlayerPositionList(), getModel().getComputerPositionList());
//        if (!button7Clicked) {
//            if (getModel().playerOnesTurn) {
//                setButtonTextToO(getModel().button7PropertyProperty());
//                getModel().setPlayerTwosTurn();
//                getModel().getPlayerPositionList().add(7);
//            } else {
//                setButtonTextToX(getModel().button7PropertyProperty());
//                getModel().setPlayerOnesTurn();
//                getModel().getComputerPositionList().add(7);
//            }
//            button7Clicked = true;
//            getModel().checkWin();
//        }
    }

    public void Button8Clicked(MouseEvent mouseEvent) {
        handleButtonClick(button8, 8, buttonClickedArray, getModel().getPlayerPositionList(), getModel().getComputerPositionList());
//        if (!button8Clicked) {
//            if (getModel().playerOnesTurn) {
//                setButtonTextToO(getModel().button8PropertyProperty());
//                getModel().setPlayerTwosTurn();
//                getModel().getPlayerPositionList().add(8);
//            } else {
//                setButtonTextToX(getModel().button8PropertyProperty());
//                getModel().setPlayerOnesTurn();
//                getModel().getComputerPositionList().add(8);
//            }
//            button8Clicked = true;
//            getModel().checkWin();
//        }
    }

    public void Button9Clicked(MouseEvent mouseEvent) {
        handleButtonClick(button9, 9, buttonClickedArray, getModel().getPlayerPositionList(), getModel().getComputerPositionList());
//        if (!button9Clicked) {
//            if (getModel().playerOnesTurn) {
//                setButtonTextToO(getModel().button9PropertyProperty());
//                getModel().setPlayerTwosTurn();
//                getModel().getPlayerPositionList().add(9);
//            } else {
//                setButtonTextToX(getModel().button9PropertyProperty());
//                getModel().setPlayerOnesTurn();
//                getModel().getComputerPositionList().add(9);
//            }
//            button9Clicked = true;
//            getModel().checkWin();
//        }
    }



    /**method that changes text of the button*/
    public void setButtonTextToX(StringProperty buttonProperty) {
        buttonProperty.set("X");
    }
    public void setButtonTextToO(StringProperty buttonProperty) {
        buttonProperty.set("O");
    }

}
