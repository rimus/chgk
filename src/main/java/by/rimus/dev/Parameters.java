package by.rimus.dev;

import com.beust.jcommander.Parameter;

public final class Parameters {

    private static Parameters instance;

    @Parameter(names = {"--help", "-h"}, help = true, description = "Help")
    private boolean help;

    @Parameter(names = {"-players", "-p"}, description = "Player ids, separated by semicolon", required = true)
    private String players;

    @Parameter(names = {"--team", "-t"}, description = "Team id", required = true)
    private int teamId;

    @Parameter(names = {"--rb", "-r"}, description = "Team TRB", required = true)
    private int rb;

    @Parameter(names = {"--questions", "-q"}, description = "All questions number", required = true)
    private int questions;

    @Parameter(names = {"--fails", "-f"}, description = "Failed questions number", required = true)
    private int fails;

    private Parameters() {
    }

    public static synchronized Parameters getInstance() {
        if (instance == null) {
            instance = new Parameters();
        }
        return instance;
    }

    public boolean isHelp() {
        return help;
    }

    public String[] getPlayers() {
        return players.split(";");
    }

    public int getTeamId() {
        return teamId;
    }

    public int getRb() {
        return rb;
    }

    public int getQuestions() {
        return questions;
    }

    public int getFails() {
        return fails;
    }
}
