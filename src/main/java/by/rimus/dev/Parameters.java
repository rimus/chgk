package by.rimus.dev;

import com.beust.jcommander.Parameter;

public final class Parameters {

    private static Parameters instance;

    @Parameter(names = {"--help", "-h"}, help = true, description = "Help")
    private boolean help;

    @Parameter(names = {"-players", "-p"}, description = "Player IDs, separated by semicolon", required = true)
    private String players;

    @Parameter(names = {"--team", "-t"}, description = "Team ID", required = true)
    private int idTeam;

    @Parameter(names = {"--questions", "-q"}, description = "All questions number", required = true)
    private int questions;

    @Parameter(names = {"--answers", "-a"}, description = "Correct answers number", required = true)
    private int answers;

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

    public int getIdTeam() {
        return idTeam;
    }

    public int getQuestions() {
        return questions;
    }

    public int getAnswers() {
        return answers;
    }
}
