package by.rimus.dev.chgk.constants;

public class Constants {

    public static final String API_ROOT_URL = "http://rating.chgk.info/api/";
    public static final String API_PLAYER_PATTERN = API_ROOT_URL + "players/%d.json";
    public static final String API_PLAYER_EXTEND_PATTERN = API_ROOT_URL + "players/%d/rating/last.json";
    public static final String API_TEAM_PATTERN = API_ROOT_URL + "teams/%d.json";
    public static final String API_TEAM_RECAPS_PATTERN = API_ROOT_URL + "teams/%d/recaps/last.json";
    public static final String API_TEAM_EXTEND_PATTERN = API_ROOT_URL + "teams/%d/rating/b.json";
}
