package com.organization.mvcproject.service;

import java.util.List;

import com.organization.mvcproject.api.dao.GameDAO;
import com.organization.mvcproject.api.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.mvcproject.api.model.Game;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameDAO games;

	@Override
	public List<Game> retrieveAllGames() { return games.retrieveAllGames();}

	@Override
	public Game saveGame(Game game) {
		return games.saveGame(game);
	}

	@Override
	public Game addOrUpdateGame(Game newGame) {
		return games.addOrUpdateGame(newGame);
	}

	@Override
	public Game deleteGame(Game game) {
		return games.deleteGame(game);
	}


}