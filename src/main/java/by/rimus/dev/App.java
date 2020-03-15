package by.rimus.dev;

import by.rimus.dev.config.Parameters;
import by.rimus.dev.logger.Log;
import by.rimus.dev.model.Player;
import by.rimus.dev.model.Team;
import by.rimus.dev.service.PlayerService;
import by.rimus.dev.service.TeamService;
import by.rimus.dev.utils.Util;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@ComponentScan("by.rimus.dev")
public class App {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private TeamService teamService;

    public static void main(String[] args) {

        parseCli(args);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        App app = ctx.getBean(App.class);
        Team team = app.teamService.getTeamById(Parameters.getInstance().getIdTeam());
        List<Player> baseTopSix = Util.getTopSixPlayers(team.getBaseSquad());
        List<Player> actualTopSix = Util.getTopSixPlayers(
                app.getFactSquadFromCommandLineArgs(Parameters.getInstance().getPlayers()));
        Log.info("Actual squad: " + Util.getSurnamesFromSquad(actualTopSix));
        int rb = team.getTechRatingTeam();
        int rt = rb * Util.getSumWithCoeffs(actualTopSix) / Util.getSumWithCoeffs(baseTopSix);
        int rg = team.getRatingTeam() * rt / rb;
        Log.info("RG = " + rg);
        int answers = Parameters.getInstance().getAnswers();
        int questions = Parameters.getInstance().getQuestions();
        int fails = questions - answers;
        double dl = (double) rg * fails / questions / 500;
        Log.info(String.format("DL = %.1f", dl));
    }

    private static void parseCli(String[] args) {
        JCommander jCommander = new JCommander(Parameters.getInstance());
        try {
            jCommander.parse(args);
        } catch (ParameterException e) {
            Log.error("CLI parameters are incorrect! Use --help");
            System.exit(1);
        }
        if (Parameters.getInstance().isHelp()) {
            jCommander.usage();
            System.exit(0);
        }
    }

    private List<Player> getFactSquadFromCommandLineArgs(String[] ids) {
        List<Player> factSquad = new ArrayList<>();
        for (String idPlayer : ids) {
            factSquad.add(playerService.getPlayerById(Integer.parseInt(idPlayer)));
        }
        Collections.sort(factSquad);
        return factSquad;
    }
}
