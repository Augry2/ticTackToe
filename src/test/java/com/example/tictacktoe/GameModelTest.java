package com.example.tictacktoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameModelTest {

    @Test
    @DisplayName("button can only be clicked once")
    void buttonCanOnlyBeClickedOnce() {
        GameModel model = new GameModel();

        model.buttonClick(1);
        model.buttonClick(1);
        model.buttonClick(1);

        assertEquals(1, model.getPlayerPositionList().size());
        assertEquals(1, model.getComputerPositionList().size());

    }

    @Test
    @DisplayName("computer clicks are generated after a player clicks a button")
    void computerClicksAreGeneratedAfterAPlayerClicksAButton() {
        GameModel model = new GameModel();

        assertTrue(model.getComputerPositionList().isEmpty());

        model.buttonClick(1);

        assertFalse(model.getComputerPositionList().isEmpty());
    }

    @Test
    @DisplayName("button clicks are saved")
    void buttonClicksAreSaved() {
        GameModel model = new GameModel();

        assertTrue(model.getPlayerPositionList().isEmpty());

        model.buttonClick(1);

        assertTrue(model.getPlayerPositionList().contains(1));
    }

    @Test
    @DisplayName("player can win a round")
    void playerCanWinARound() {
        GameModel model = new GameModel();

        model.getPlayerPositionList().add(1);
        model.getPlayerPositionList().add(2);
        model.getPlayerPositionList().add(3);

        assertTrue(model.checkEndRound());
        assertTrue(model.winnerAnnounceProperty().get().contains("Player Won"));
    }

    @Test
    @DisplayName("computer can win a round")
    void computerCanWinARound() {
        GameModel model = new GameModel();

        model.getComputerPositionList().add(1);
        model.getComputerPositionList().add(2);
        model.getComputerPositionList().add(3);

        assertTrue(model.checkEndRound());
        assertTrue(model.winnerAnnounceProperty().get().contains("Computer Won"));
    }

    @Test
    @DisplayName("game can be a tie")
    void gameCanBeATie() {
        GameModel model = new GameModel();

        model.getPlayerPositionList().add(1);
        model.getComputerPositionList().add(2);
        model.getPlayerPositionList().add(3);
        model.getComputerPositionList().add(4);
        model.getComputerPositionList().add(5);
        model.getPlayerPositionList().add(6);
        model.getComputerPositionList().add(7);
        model.getPlayerPositionList().add(8);
        model.getComputerPositionList().add(9);

        assertTrue(model.checkEndRound());
        assertTrue(model.winnerAnnounceProperty().get().contains("The game is a tie"));
    }


}