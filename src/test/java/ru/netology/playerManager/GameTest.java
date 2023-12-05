package ru.netology.playerManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();
    List<String> sp = new ArrayList<>();
    Player player1 = new Player(5, "Jon", 100);
    Player player2 = new Player(5, "Mary", 200);
    Player player3 = new Player(5, "Stiff", 300);
    Player player4 = new Player(5, "Death", 50);
    Player player5 = new Player(5, "Clone", 30);
    Player player6 = new Player(5, "Baba-duck", 200);

    @Test
    public void registerThreePlayer() {

        game.register(player1);
        game.register(player2);
        game.register(player3);


        List<Player> expected = List.of(player1, player2, player3);
        List<Player> actual = game.listOfPlayers;
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void registerNowPlayer() {

        List<Player> expected = List.of();
        List<Player> actual = game.listOfPlayers;
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void nowRegisterPlayerOne() {
        game.register(player1);
        game.register(player2);
        game.register(player3);


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Luiza", "Jon");
        });
    }

    @Test
    public void nowRegisterPlayerTwo() {
        game.register(player1);
        game.register(player2);
        game.register(player3);


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Jon", "Luiza");
        });

    }

    @Test
    public void contestPlayerWinnerOne() {
        game.register(player1);
        game.register(player2);
        game.register(player3);


        int expected = 1;
        int actual = game.round("Mary", "Jon");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void contestPlayerWinnerTwo() {
        game.register(player1);
        game.register(player2);
        game.register(player3);


        int expected = 2;
        int actual = game.round("Jon", "Mary");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void contestPlayerNobody() {
        game.register(player1);
        game.register(player2);
        game.register(player6);


        int expected = 0;
        int actual = game.round("Baba-duck", "Mary");

        Assertions.assertEquals(expected, actual);
    }


}