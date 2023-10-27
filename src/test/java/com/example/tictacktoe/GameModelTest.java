package com.example.tictacktoe;

import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameModelTest {
GameModel model = new GameModel();
    @BeforeAll
    public static void initJavaFX() {
        // Initialize JavaFX Toolkit
        Platform.startup(() -> {
        });
    }
    @BeforeEach
    public void setUp() {
         model = new GameModel(); // Initialize the controller before each test
    }


}