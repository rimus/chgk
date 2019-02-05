package by.rimus.dev.chgk.utils;

import by.rimus.dev.chgk.bo.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerFactory {

    public static Player getPlayer(int playerId) {
        return new Player(playerId);
    }

    public static List<Player> getPlayerList(List<String> list) {
        List<Player> players = new ArrayList<>();
        for (String value : list) {
            players.add(getPlayer(Integer.parseInt(value)));
        }
        return players;
    }
}
