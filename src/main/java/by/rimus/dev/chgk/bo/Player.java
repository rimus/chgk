package by.rimus.dev.chgk.bo;

public class Player implements Comparable<Player> {

    private int id;
    private int rating;
    private String name;
    private String surname;
    private Team team;

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = Integer.parseInt(id);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setRating(String rating) {
        this.rating = Integer.parseInt(rating);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    @Override
    public String toString() {
        return getFullName() + " rate = " + rating + " (id: " + id + ")";
    }

    public int compareTo(Player player) {
        return player.rating - this.rating;
    }
}
