package by.rimus.dev.chgk.bo;

import by.rimus.dev.chgk.utils.ApiUtils;
import by.rimus.dev.chgk.utils.PlayerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Team {

    private int id;
    private int rating;
    private String name;
    private List<Player> baseSquad;

    public Team(int id) {
        this.id = id;
        rating = Integer.parseInt(ApiUtils.getTeamRatingFromJsonById(id));
        name = ApiUtils.getTeamNameFromJsonById(id);
        baseSquad = PlayerFactory.getPlayerList(ApiUtils.getBaseSquadFromJsonById(id));
        Collections.sort(baseSquad);
    }

    public int getId() {
        return id;
    }

    public int getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public List<Player> getBaseSquad() {
        return baseSquad;
    }

    public static List<Player> getTopSix(List<Player> players) {
        List<Player> topSix = new ArrayList<>();
        Iterator<Player> iterator = players.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            if (i == 6) {
                break;
            }
            topSix.add(iterator.next());
            i++;
        }
        return topSix;
    }

    public static int getSumWithCoeffs(List<Player> players) {
        int q = 6;
        int sum = 0;
        for (Player player : players) {
            sum += Math.round(player.getRating() * (q / 6.0));
            q--;
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Team: " + name + ", rate = " + rating + " (id: " + id + ")";
    }
}
