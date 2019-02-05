package by.rimus.dev;

import by.rimus.dev.chgk.bo.Player;
import by.rimus.dev.chgk.bo.Team;
import by.rimus.dev.chgk.utils.PlayerFactory;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        parseCli(args);
        Team team = new Team(Parameters.getInstance().getTeamId());
        List<Player> baseTopSix = Team.getTopSix(team.getBaseSquad());
        List<Player> factTopSix = Team.getTopSix(getFactSquadFromArgs(Parameters.getInstance().getPlayers()));
        int rb = Parameters.getInstance().getRb();
        int rt = Team.getSumWithCoeffs(factTopSix) * rb / Team.getSumWithCoeffs(baseTopSix);
        int rg = team.getRating() * rt / rb;
        int dl = rg * Parameters.getInstance().getFails() / Parameters.getInstance().getQuestions();
        System.out.println("RG: " + rg);
        System.out.println("DL: " + dl);
    }


    private static void parseCli(String[] args) {
        JCommander jCommander = new JCommander(Parameters.getInstance());
        try {
            jCommander.parse(args);
        } catch (ParameterException e) {
            System.err.println("CLI parameters are incorrect! Use --help");
            System.exit(1);
        }
        if (Parameters.getInstance().isHelp()) {
            jCommander.usage();
            System.exit(0);
        }
    }

    private static List<Player> getFactSquadFromArgs(String[] args) {
        List<Player> factSquad = new ArrayList<>();
        for (String arg : args) {
            factSquad.add(PlayerFactory.getPlayer(Integer.parseInt(arg)));
        }
        Collections.sort(factSquad);
        return factSquad;
    }
}
