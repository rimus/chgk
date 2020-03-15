package by.rimus.dev.utils;

import by.rimus.dev.model.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Util {

    public static String getSurnamesFromSquad(List<Player> players) {
        StringBuilder sb = new StringBuilder();
        for (Player player : players) {
            sb.append(player.getSurname());
            sb.append(" ");
        }
        return sb.toString();
    }

    public static List<Player> getTopSixPlayers(List<Player> players) {
        List<Player> topSixPlayers = new ArrayList<>();
        Iterator<Player> iterator = players.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            if (i == 6) {
                break;
            }
            topSixPlayers.add(iterator.next());
            i++;
        }
        return topSixPlayers;
    }

    public static int getSumWithCoeffs(List<Player> players) {
        int q = 6;
        int sum = 0;
        for (Player player : players) {
            sum += Math.round(player.getRatingPlayer() * (q / 6.0));
            q--;
        }
        return sum;
    }
}
