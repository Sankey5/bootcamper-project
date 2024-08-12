package com.organization.mvcproject.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.organization.mvcproject.api.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.organization.mvcproject.model.GameImpl;
import com.organization.mvcproject.api.service.GameService;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


@RequestMapping(value = "/game")
@RestController
public class GameController {

	@Autowired
	private GameService gameService;

	private static final String UPLOAD_DIRECTORY = "\\game_art\\";

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
		Game savedGame = gameService.updateGame(game);

		if(savedGame != null)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> updateGame(@PathVariable int id) {
		boolean gameDeleted = gameService.deleteGame(id);

		if(gameDeleted)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	/*@PostMapping(value = "uploadCoverArt")
	public @ResponseBody String uploadFile (
			HttpServletRequest servletRequest,
			@RequestParam("file") MultipartFile file) {

		String originalFileName = file.getOriginalFilename();

		if(!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				String pathToFile = servletRequest.getServletContext().getRealPath("\\" +
						UPLOAD_DIRECTORY + originalFileName);

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(pathToFile)));

				stream.write(bytes);
				stream.close();

			} catch(IOException e) {
				e.printStackTrace();
				return "You failed to upload " + originalFileName + "!";
			}

			return "You successfully uploaded " + originalFileName + "!";
		}

		return "You failed to upload " + originalFileName + " because the file was empty.";
	}*/
}