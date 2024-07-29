package com.organization.mvcproject.service;

import java.util.List;

import com.organization.mvcproject.model.Game;

//TODO 1.0  follow java interface naming conventions, improve interface name
public interface Game_Service {

	List<Game> retrieveAllGames();

	Game saveGame(Game game);

}
