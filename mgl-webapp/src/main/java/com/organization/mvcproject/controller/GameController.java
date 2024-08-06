package com.organization.mvcproject.controller;

import java.util.List;

import com.organization.mvcproject.api.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.organization.mvcproject.model.GameImpl;
import com.organization.mvcproject.api.service.GameService;


@RequestMapping(value = "/game")
@RestController
public class GameController {

	@Autowired
	private GameService gameService;

	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Game>> fetchAllGames() {
		return new ResponseEntity<>(gameService.retrieveAllGames(), HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> createGame(@RequestBody GameImpl game) {
		gameService.saveGame(game);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateGame(@RequestBody GameImpl game) {
		Game savedGame = gameService.addOrUpdateGame(game);

		if(savedGame != null)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.CREATED);
	}
}