package by.rimus.dev.dao.impl;

import by.rimus.dev.constants.Constants;
import by.rimus.dev.dao.IPlayerDAO;
import by.rimus.dev.model.Player;
import by.rimus.dev.utils.RatingApiUtils;
import io.restassured.response.Response;
import org.springframework.stereotype.Component;

@Component
public class PlayerDAOImpl implements IPlayerDAO {

    private static final String API_PLAYER_PATTERN = Constants.API_URL + "players/%d.json";
    private static final String API_PLAYER_LAST_RELEASE_PATTERN = Constants.API_URL + "players/%d/rating/last.json";

    private static final String JSON_PATH_NAME = "name";
    private static final String JSON_PATH_SURNAME = "surname";
    private static final String JSON_PATH_PATRONYMIC = "patronymic";
    private static final String JSON_PATH_RATING = "rating";

    private Response playerJsonResponse;

    private Response playerLastReleaseJsonResponse;

    @Override
    public Player getPlayerById(int idPlayer) {
        String playerJsonUrl = String.format(API_PLAYER_PATTERN, idPlayer);
        String playerLastReleaseJsonUrl = String.format(API_PLAYER_LAST_RELEASE_PATTERN, idPlayer);
        initJsonResponses(playerJsonUrl, playerLastReleaseJsonUrl);
        Player player = new Player();
        player.setIdPlayer(idPlayer);
        player.setSurname(RatingApiUtils.getValueByJsonPath(playerJsonResponse, JSON_PATH_SURNAME));
        player.setName(RatingApiUtils.getValueByJsonPath(playerJsonResponse, JSON_PATH_NAME));
        player.setPatronymic(RatingApiUtils.getValueByJsonPath(playerJsonResponse, JSON_PATH_PATRONYMIC));
        player.setRatingPlayer(RatingApiUtils.getValueByJsonPath(playerLastReleaseJsonResponse, JSON_PATH_RATING));
        return player;
    }

    private void initJsonResponses(String playerJsonUrl, String playerLastReleaseJsonUrl) {
        playerJsonResponse = RatingApiUtils.getResponse(playerJsonUrl);
        playerLastReleaseJsonResponse = RatingApiUtils.getResponse(playerLastReleaseJsonUrl);
    }
}
