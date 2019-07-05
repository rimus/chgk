package by.rimus.dev.service.impl;

import by.rimus.dev.dao.IPlayerDAO;
import by.rimus.dev.model.Player;
import by.rimus.dev.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private IPlayerDAO playerDAO;

    @Override
    public Player getPlayerById(int idPlayer) {
        return playerDAO.getPlayerById(idPlayer);
    }
}
