package by.rimus.dev;

import by.rimus.dev.chgk.bo.Player;
import by.rimus.dev.chgk.utils.ApiUtils;
import by.rimus.dev.chgk.utils.PlayerFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DebugRunner {

    public static void main(String[] args) {

        List<Player> players = Arrays.asList(
                PlayerFactory.getPlayer(3868),
                PlayerFactory.getPlayer(6780),
                PlayerFactory.getPlayer(10177),
                PlayerFactory.getPlayer(84377),
                PlayerFactory.getPlayer(96636),
                PlayerFactory.getPlayer(96638),
                PlayerFactory.getPlayer(114347),
                PlayerFactory.getPlayer(124135),
                PlayerFactory.getPlayer(152803)
        );
        Collections.sort(players);
        players.forEach(System.out::println);

        List<String> base = ApiUtils.getBaseSquadFromJsonById(50905);
        base.forEach(System.out::println);

    }
}
