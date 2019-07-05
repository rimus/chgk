package by.rimus.dev.dao.impl;

import by.rimus.dev.constants.Constants;
import by.rimus.dev.dao.IPlayerDAO;
import by.rimus.dev.dao.ITeamDAO;
import by.rimus.dev.model.Player;
import by.rimus.dev.model.Team;
import by.rimus.dev.utils.RatingApiUtils;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class TeamDAOImpl implements ITeamDAO {

    @Autowired
    private IPlayerDAO playerDAO;

    private static final String API_TEAM_PATTERN = Constants.API_URL + "teams/%d.json";
    private static final String API_TEAM_RECAPS_PATTERN = Constants.API_URL + "teams/%d/recaps/last.json";
    private static final String API_TEAM_RATING_PATTERN = Constants.API_URL + "teams/%d/rating/b.json";

    private static final String JSON_PATH_NAME = "name";
    private static final String JSON_PATH_TOWN = "town";
    private static final String JSON_PATH_REGION_NAME = "region_name";
    private static final String JSON_PATH_COUNTRY_NAME = "country_name";
    private static final String JSON_PATH_RATING = "rating";
    private static final String JSON_PATH_TECH_RATING = "tech_rating";
    private static final String JSON_PATH_PLAYERS = "players";

    private Response teamJsonResponse;

    private Response teamRecapsJsonResponse;

    private Response teamRatingResponse;

    @Override
    public Team getTeamById(int idTeam) {
        String teamJsonUrl = String.format(API_TEAM_PATTERN, idTeam);
        String teamRecapsJsonUrl = String.format(API_TEAM_RECAPS_PATTERN, idTeam);
        String teamRatingJsonUrl = String.format(API_TEAM_RATING_PATTERN, idTeam);
        initJsonResponses(teamJsonUrl, teamRecapsJsonUrl, teamRatingJsonUrl);
        Team team = new Team();
        team.setIdTeam(idTeam);
        team.setName(RatingApiUtils.getValueByJsonPath(teamJsonResponse, JSON_PATH_NAME));
        team.setTown(RatingApiUtils.getValueByJsonPath(teamJsonResponse, JSON_PATH_TOWN));
        team.setRegionName(RatingApiUtils.getValueByJsonPath(teamJsonResponse, JSON_PATH_REGION_NAME));
        team.setCountryName(RatingApiUtils.getValueByJsonPath(teamJsonResponse, JSON_PATH_COUNTRY_NAME));
        team.setRatingTeam(RatingApiUtils.getValueByJsonPath(teamRatingResponse, JSON_PATH_RATING));
        team.setTechRatingTeam(RatingApiUtils.getValueByJsonPath(teamRatingResponse, JSON_PATH_TECH_RATING));
        team.setBaseSquad(getBaseSquadFromStringPlayersIdsList(
                RatingApiUtils.getStringListByJsonPath(teamRecapsJsonResponse, JSON_PATH_PLAYERS)));
        return team;
    }

    private void initJsonResponses(String teamJsonUrl, String teamRecapsJsonUrl, String teamRatingJsonUrl) {
        teamJsonResponse = RatingApiUtils.getResponse(teamJsonUrl);
        teamRecapsJsonResponse = RatingApiUtils.getResponse(teamRecapsJsonUrl);
        teamRatingResponse = RatingApiUtils.getResponse(teamRatingJsonUrl);
    }

    private List<Player> getBaseSquadFromStringPlayersIdsList(List<String> baseSquadPlayersIds) {
        List<Player> baseSquad = new ArrayList<>();
        for (String idPlayer : baseSquadPlayersIds) {
            baseSquad.add(playerDAO.getPlayerById(Integer.valueOf(idPlayer)));
        }
        Collections.sort(baseSquad);
        return baseSquad;
    }
}
