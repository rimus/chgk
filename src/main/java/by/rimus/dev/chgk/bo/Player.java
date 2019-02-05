package by.rimus.dev.chgk.bo;

import by.rimus.dev.chgk.utils.ApiUtils;

public class Player implements Comparable<Player> {

    private int id;
    private int rating;
    private String name;
    private String surname;

    public Player(int id) {
        this.id = id;
        rating = Integer.parseInt(ApiUtils.getPlayerRatingFromJsonById(id));
        name = ApiUtils.getPlayerNameFromJsonById(id);
        surname = ApiUtils.getPlayerSurnameFromJsonById(id);
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

    public String getSurname() {
        return surname;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    @Override
    public String toString() {
        return "Player: " + getFullName() + ", rate = " + rating + " (id: " + id + ")";
    }

    public int compareTo(Player player) {
        return player.rating - this.rating;
    }
}
