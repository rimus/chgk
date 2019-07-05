package by.rimus.dev.model;

public class Player implements Comparable<Player> {

    private int idPlayer;
    private String surname;
    private String name;
    private String patronymic;
    private int ratingPlayer;

    public int getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getRatingPlayer() {
        return ratingPlayer;
    }

    public void setRatingPlayer(int ratingPlayer) {
        this.ratingPlayer = ratingPlayer;
    }

    public void setRatingPlayer(String ratingPlayer) {
        this.ratingPlayer = Integer.valueOf(ratingPlayer);
    }

    public String getFullName() {
        return surname + " " + name + " " + patronymic;
    }

    @Override
    public String toString() {
        return "Player with id " + idPlayer + ", " + getFullName() + ", rating = " + ratingPlayer;
    }

    public int compareTo(Player player) {
        return player.ratingPlayer - this.ratingPlayer;
    }
}
