package com.organization.mvcproject.MGL_Task1.model;

import org.springframework.stereotype.Component;

@Component
public class Game {

	/**
	 * TODO 1.0 java object member variable naming convention declared here are not object oriented,
	 *  rename the variables, and their setter/getter methods to match convention. 
	 */
	private Long game_id;
	private String game_name;
	private String game_genre;

	public Long getGame_id() {
		return game_id;
	}

	public void setGame_id(Long game_id) {
		this.game_id = game_id;
	}

	public String getGame_name() {
		return game_name;
	}

	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}

	public String getGame_genre() {
		return game_genre;
	}

	public void setGame_genre(String game_genre) {
		this.game_genre = game_genre;
	}

}
