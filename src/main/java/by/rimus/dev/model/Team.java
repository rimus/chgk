package by.rimus.dev.model;

import java.util.List;

public class Team {

    private int idTeam;
    private String name;
    private String town;
    private String regionName;
    private String countryName;
    private int ratingTeam;
    private int techRatingTeam;
    private List<Player> baseSquad;

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getRatingTeam() {
        return ratingTeam;
    }

    public void setRatingTeam(int ratingTeam) {
        this.ratingTeam = ratingTeam;
    }

    public void setRatingTeam(String ratingTeam) {
        this.ratingTeam = Integer.parseInt(ratingTeam);
    }

    public int getTechRatingTeam() {
        return techRatingTeam;
    }

    public void setTechRatingTeam(int techRatingTeam) {
        this.techRatingTeam = techRatingTeam;
    }

    public void setTechRatingTeam(String techRatingTeam) {
        this.techRatingTeam = Integer.parseInt(techRatingTeam);
    }

    public List<Player> getBaseSquad() {
        return baseSquad;
    }

    public void setBaseSquad(List<Player> baseSquad) {
        this.baseSquad = baseSquad;
    }

    @Override
    public String toString() {
        return "Team \"" + name + "\" with id " + idTeam + ". R = " + ratingTeam + "; RB = " + techRatingTeam;
    }
}
