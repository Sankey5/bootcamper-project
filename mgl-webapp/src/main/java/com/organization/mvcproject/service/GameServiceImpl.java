package com.organization.mvcproject.service;

import java.util.List;

import com.organization.mvcproject.api.dao.GameDAO;
import com.organization.mvcproject.api.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.model.Game;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	@Qualifier("gameLoopBasedDAO")
	private GameDAO games;

	@Override
	public List<Game> retrieveAllGames() { return games.retrieveAllGames();}

	@Override
	public Game saveGame(Game game) {
		return games.saveGame(game);
	}

	@Override
	public Game updateGame(Game newGame) { return games.updateGame(newGame); }

	@Override
	public boolean deleteGame(int gameId) { return games.deleteGame(gameId); }


}