package com.example.tictacktoe;

import javafx.application.Platform;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameModelTest {
GameModel model;
GameController controller;
    @BeforeAll
    public static void initJavaFX() {
        // Initialize JavaFX Toolkit
        Platform.startup(() -> {
        });
    }
    @BeforeEach
    public void setUp() {
        model = new GameModel();
        controller = new GameController();
        controller.initialize();
    }

    @Test
    @DisplayName("player wins if he has three in a row")
    void playerWinsIfHeHasThreeInARow() {
        List<Integer> playerPos = model.getPlayerPositionList();
        playerPos.add(1);
        playerPos.add(2);
        playerPos.add(3);

        model.checkWin();

        assertTrue(model.getWinner().contains("Player Won"));
    }

    @Test
    @DisplayName("computer wins if he gets three in a row")
    void computerWinsIfHeGetsThreeInARow() {
        List<Integer> computerPos = model.getComputerPositionList();
        computerPos.add(1);
        computerPos.add(2);
        computerPos.add(3);

        model.checkWin();

        assertTrue(model.getWinner().contains("Computer Won"));
    }

    @Test
    @DisplayName("round ends if program runs out of buttons")
    void roundEndsIfProgramRunsOutOfButtons() {
        List<Integer> playerPos = model.getPlayerPositionList();
        List<Integer> computerPos = model.getComputerPositionList();
        // row 1
        playerPos.add(1);
        playerPos.add(2);
        computerPos.add(3);
        // row 2
        computerPos.add(4);
        computerPos.add(5);
        playerPos.add(6);
         // row 3
        playerPos.add(7);
        computerPos.add(8);
        computerPos.add(9);

        assertFalse(model.checkWin());
        assertTrue(model.getWinner().contains("Nobody won"));
    }


}