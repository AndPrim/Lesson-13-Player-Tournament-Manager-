package ru.netology.playerManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    //Player player = new Player();

    List<Player> listOfPlayers = new ArrayList<>();

    public void register(Player player) {
        listOfPlayers.add(player);
    }

    public Player findNamePlayer(String name) {
        for (Player players : listOfPlayers) {
            if (players.getName().equals(name)) {
                return players;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = findNamePlayer(playerName1);
        Player player2 = findNamePlayer(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException(
                    "Игрок с именем: " + playerName1 + " не зарегистрирован"
            );
        }
        if (player2 == null) {
            throw new NotRegisteredException(
                    "Игрок с именем: " + playerName2 + " не зарегистрирован"
            );
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
