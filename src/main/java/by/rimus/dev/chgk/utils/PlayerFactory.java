package by.rimus.dev.chgk.utils;

import by.rimus.dev.chgk.bo.Player;

public class PlayerFactory {

    public static Player getPlayer(int playerId) {
        Player player = new Player();
        player.setId(ApiUtils.getPlayerIdFromJsonById(playerId));
        player.setName(ApiUtils.getPlayerNameFromJsonById(playerId));
        player.setSurname(ApiUtils.getPlayerSurnameFromJsonById(playerId));
        player.setRating(ApiUtils.getPlayerRatingFromJsonById(playerId));
        return player;
    }
}
