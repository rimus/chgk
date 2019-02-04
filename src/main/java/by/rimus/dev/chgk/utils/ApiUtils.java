package by.rimus.dev.chgk.utils;

import by.rimus.dev.chgk.constants.Constants;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

public class ApiUtils {

    private static final String BRACES_REG_EXP = "[\\[\\]]";
    private static final String EMPTY = "";
    private static final String ID_PLAYER_JSON_PATH = "idplayer";
    private static final String NAME_JSON_PATH = "name";
    private static final String SURNAME_JSON_PATH = "surname";
    private static final String PLAYER_RATING_JSON_PATH = "rating";
    private static final String PLAYERS_RATING_JSON_PATH = "players";

    private static Response getResponse(String url) {
        return RestAssured.given().when().get(url);
    }

    private static String getValueByJsonPath(String url, String jsonPath) {
        return JsonPath.from(getResponse(url).asString()).getString(jsonPath);
    }

    private static List<String> getListByJsonPath(String url, String jsonPath) {
        return JsonPath.from(getResponse(url).asString()).getList(jsonPath);
    }

    public static String getPlayerIdFromJsonById(int playerId) {
        String url = String.format(Constants.API_PLAYER_PATTERN, playerId);
        return getValueByJsonPath(url, ID_PLAYER_JSON_PATH).replaceAll(BRACES_REG_EXP, EMPTY);
    }

    public static String getPlayerNameFromJsonById(int playerId) {
        String url = String.format(Constants.API_PLAYER_PATTERN, playerId);
        return getValueByJsonPath(url, NAME_JSON_PATH).replaceAll(BRACES_REG_EXP, EMPTY);
    }

    public static String getPlayerSurnameFromJsonById(int playerId) {
        String url = String.format(Constants.API_PLAYER_PATTERN, playerId);
        return getValueByJsonPath(url, SURNAME_JSON_PATH).replaceAll(BRACES_REG_EXP, EMPTY);
    }

    public static String getPlayerRatingFromJsonById(int playerId) {
        String url = String.format(Constants.API_PLAYER_EXTEND_PATTERN, playerId);
        return getValueByJsonPath(url, PLAYER_RATING_JSON_PATH);
    }

    public static List<String> getBaseSquadFromJsonById(int teamId) {
        String url = String.format(Constants.API_TEAM_PATTERN, teamId);
        return getListByJsonPath(url, PLAYER_RATING_JSON_PATH);
    }
}
