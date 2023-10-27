package com.example.tictacktoe;

import static org.junit.jupiter.api.Assertions.*;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GameControllerTest {
    private GameController controller;
    private GameModel model;
    @BeforeAll
    public static void initJavaFX() {
        // Initialize JavaFX Toolkit
        Platform.startup(() -> {
        });
    }
    @BeforeEach
    public void setUp() {
        model = new GameModel();
        controller = new GameController(); // Initialize the controller before each test

        controller.initialize(); // Call initialize() method manually to bind buttons
    }

    @Test
    @DisplayName("buttonIsClicked")
    void buttonIsClicked() {

        assertFalse(model.playerOnesTurn);
    }
}