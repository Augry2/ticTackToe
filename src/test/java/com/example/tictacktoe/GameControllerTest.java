package com.example.tictacktoe;

import static org.junit.jupiter.api.Assertions.*;

import javafx.application.Platform;
import javafx.scene.control.Button;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;

class GameControllerTest {
    private GameController controller;

    @BeforeAll
    public static void initJavaFX() {
        // Initialize JavaFX Toolkit
        Platform.startup(() -> {
        });
    }

    @BeforeEach
    public void setUp() {
        controller = new GameController(); // Initialize the controller before each test
        controller.initialize(); // Call initialize() method manually to bind buttons
    }

    @Test
    @DisplayName("button click is saved in a list")
    void buttonClickIsSavedInAList() {
        Button button1 = controller.button1;
        boolean[] buttonsClicked = controller.getButtonsClicked();
        List<Integer> playerPositionList = controller.getModel().getPlayerPositionList();
        List<Integer> computerPositionList = controller.getModel().getComputerPositionList();

        controller.handleButtonClick(button1,1,buttonsClicked, playerPositionList, computerPositionList);

        assertTrue(buttonsClicked[0]);
    }

    @Test
    @DisplayName("button can only be pressed once")
    void buttonCanOnlyBePressedOnce() {
        Button button1 = controller.button1;
        boolean[] buttonsClicked = controller.getButtonsClicked();
        List<Integer> playerPositionList = controller.getModel().getPlayerPositionList();
        List<Integer> computerPositionList = controller.getModel().getComputerPositionList();

        controller.handleButtonClick(button1,1,buttonsClicked, playerPositionList, computerPositionList);
        assertEquals("O", button1.getText());
        assertTrue(buttonsClicked[0]);

        controller.handleButtonClick(button1,1,buttonsClicked, playerPositionList, computerPositionList);
        assertTrue(buttonsClicked[0]);
        assertEquals("O", button1.getText());
    }






}