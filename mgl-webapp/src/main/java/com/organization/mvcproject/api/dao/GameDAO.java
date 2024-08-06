package com.organization.mvcproject.api.dao;

import com.organization.mvcproject.api.model.Game;

import java.util.List;

public interface GameDAO {
    List<Game> retrieveAllGames();

    Game saveGame(Game game);

    Game addOrUpdateGame(Game newGame);

    Game deleteGame(Game game);
}
