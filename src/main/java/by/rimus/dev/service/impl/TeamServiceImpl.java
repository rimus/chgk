package by.rimus.dev.service.impl;

import by.rimus.dev.dao.ITeamDAO;
import by.rimus.dev.model.Team;
import by.rimus.dev.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeamServiceImpl implements TeamService {

    @Autowired
    private ITeamDAO teamDAO;

    @Override
    public Team getTeamById(int idTeam) {
        return teamDAO.getTeamById(idTeam);
    }
}
